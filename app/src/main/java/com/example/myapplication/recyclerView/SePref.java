package com.example.myapplication.recyclerView;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DWCloud on 2016/4/19.
 */
public class SePref{

    public static final String TABLE_NAME = "SE_PREF";

    public static boolean put(String key,Object obj){
        String type = obj.getClass().getSimpleName();
        SharedPreferences sp = App.context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if("String".equals(type)){
            editor.putString(key, (String)obj);
        }
        else if("Integer".equals(type)){
            editor.putInt(key, (Integer)obj);
        }
        else if("Boolean".equals(type)){
            editor.putBoolean(key, (Boolean)obj);
        }
        else if("Float".equals(type)){
            editor.putFloat(key, (Float)obj);
        }
        else if("Long".equals(type)){
            editor.putLong(key, (Long)obj);
        }

        return  editor.commit();
    }




    public static Object get(String key,Object defObj){
        String type = defObj.getClass().getSimpleName();
        SharedPreferences sp = App.context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        if("String".equals(type)){
            return sp.getString(key, (String)defObj);
        }
        else if("Integer".equals(type)){
            return sp.getInt(key, (Integer)defObj);
        }
        else if("Boolean".equals(type)){
            return sp.getBoolean(key, (Boolean)defObj);
        }
        else if("Float".equals(type)){
            return sp.getFloat(key, (Float)defObj);
        }
        else if("Long".equals(type)){
            return sp.getLong(key, (Long)defObj);
        }

        return null;

}



    public static boolean clear(){
        SharedPreferences sp = App.context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        return editor.commit();
    }


}
