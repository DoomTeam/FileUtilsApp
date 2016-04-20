package com.example.myapplication.recyclerView;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.FileUtil;

/**
 * Created by 二更 on 2016/4/19.
 */
public class App extends Application{

    FileUtil fileUtil;
    public static  Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
