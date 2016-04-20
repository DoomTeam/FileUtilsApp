package com.example.myapplication;

import android.content.Context;
import android.widget.Toast;

/**
 * 用于防止重复点击toast
 * Created by 二更 on 2016/4/12.
 */
public class ToastUtil {

    private static Toast toast;

    public static void showLongToast(Context ctx, String msg) {
        if (toast == null) {
            toast = Toast.makeText(ctx, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.show();
    }

    public static void showShortToast(Context ctx, String msg) {
        if (toast == null) {
            toast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public static void showTimeToast(Context ctx, String msg, int duration) {
        if (toast == null) {
            toast = Toast.makeText(ctx, msg,duration);
        } else {
            toast.setText(msg);
            toast.setDuration(duration);
        }
        toast.show();
    }

}
