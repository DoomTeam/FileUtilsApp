package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.myapplication.recyclerView.RecyclerActivity;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    TextView tx_dialoh;
    TextView tx_view_dialog;
    TextView tx_in_save;
    TextView tx_out_save;
    TextView tx_recycler;
    MaterialDialog materialDialog;
    Dialog alertDialogWrapper;
    private List<String> mList;
    private String TAG = "main";
    FileUtil fileUtil;
    private final String TXT_DRICTOR="txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx_dialoh = (TextView) findViewById(R.id.tx_dialoh);
        tx_dialoh.setOnClickListener(this);
        tx_view_dialog = (TextView) findViewById(R.id.tx_view_dialog);
        tx_view_dialog.setOnClickListener(this);
        tx_recycler = (TextView) findViewById(R.id.tx_recycler);
        tx_recycler.setOnClickListener(this);
        mList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mList.add("你是猴子请来的逗比" + i);
        }
        tx_in_save = (TextView) findViewById(R.id.tx_in_save);
        tx_out_save = (TextView) findViewById(R.id.tx_out_save);
        tx_in_save.setOnClickListener(this);
        tx_out_save.setOnClickListener(this);
        fileUtil= FileUtil.getInstance(this);
        SwipeRefreshLayout refreshLayout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tx_dialoh:
                materialDialog = new MaterialDialog.Builder(this).content("内容").positiveText("yes").onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        finish();
                    }
                }).adapter(new MyAdapter(MainActivity.this, mList), new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        ToastUtil.showShortToast(MainActivity.this, String.format("你是第%s个逗比呀！", which));
                    }
                }).negativeText("no").show();
                break;
            case R.id.tx_view_dialog:
                materialDialog=new MaterialDialog.Builder(this)
                        .title("title")
                        .positiveText("yes")
                        .customView(R.layout.dialog_list,false)
                        .show();
                View view = materialDialog.getCustomView();
                ListView list=(ListView)view.findViewById(R.id.lst);
                list.setAdapter(new MyAdapter(MainActivity.this,mList));

//                alertDialogWrapper = new AlertDialogWrapper.Builder(this).setTitle("aa").setPositiveButton("doubi", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        alertDialogWrapper.cancel();
//                    }
//                }).show();
                break;
            case R.id.tx_in_save:
                try {
                    fileUtil.writeToSDCardFile(TXT_DRICTOR,"hh.txt","内容吗？",true);
                    InputStream inputStream=getAssets().open("abd.xlsx");
                    fileUtil.writeToSDCardFromInput(TXT_DRICTOR,"ol.xlsx",inputStream);
                    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
                    fileUtil.saveImageByType(bitmap,"lp.png","png");
                }catch (Exception e){}
                break;
            case R.id.tx_out_save:
                fileUtil.deleteAllDirectory(TXT_DRICTOR);
                fileUtil.deleteAllImage();
                break;
            case R.id.tx_recycler:
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
                break;
        }
    }

    private class MyAdapter extends BaseAdapter {

        private Context mContext;
        private List<String> mList;

        public MyAdapter(Context context, List<String> list) {
            this.mContext = context;
            this.mList = list;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_text, null);
                viewHolder.tx = (TextView) convertView.findViewById(R.id.tx_item);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tx.setText(mList.get(position) + "吗？");
            return convertView;
        }

        private class ViewHolder {
            TextView tx;
        }
    }
}
