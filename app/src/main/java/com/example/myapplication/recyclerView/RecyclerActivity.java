package com.example.myapplication.recyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 二更 on 2016/4/18.
 */
public class RecyclerActivity extends Activity{

    RecyclerView recyclerView;
    HomeAdapter mAdapter;
    private List<String> dates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        initDates();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter = new HomeAdapter());
//        recyclerView.addItemDecoration();
    }

    private void initDates(){
        dates=new ArrayList<>();
        for(int i=0;i<10;i++){
            dates.add("乐安之");
        }
    }

    private class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
        @Override
        public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder viewHolder=new MyViewHolder(LayoutInflater.from(RecyclerActivity.this).inflate(R.layout.item_text,parent,false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(dates.get(position));
        }

        @Override
        public int getItemCount() {
            return dates.size();
        }

        class  MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tx_item);
            }
        }
    }

}
