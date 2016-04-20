package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

	Context context;
	private SharedPreferences mPref;

	
	private static Preferences instance;

	public static Preferences getInstance(Context context, String name) {
		if (instance == null) {
			instance = new Preferences(context);
			instance.setConfigName(name);
		}
		return instance;
	}

	// 设置配置文件的名字
	public void setConfigName(String configname) {
		mPref = context.getSharedPreferences(configname, 0);
	}

	public Preferences(Context context) {
		this.context = context;
	}


	// 构造函数，顺便就设置了配置文件的名字
	public Preferences(Context context, String configname) {
		this.context = context;
		setConfigName(configname);
	}

	// 获取int类型的值
	public int getIntValue(String key) {
		return mPref.getInt(key, 0);
	}

	// 获取string类型的值
	public String getStringValue(String key) {
		return mPref.getString(key, "");
	}

	// 获取float类型的值
	public float getFloatValue(String key) {
		return mPref.getFloat(key, 0.0f);
	}

	// 获取long类型的值
	public long getLongValue(String key) {
		return mPref.getLong(key, 0);
	}

	// 获取Boolean类型的值
	public Boolean getBooleanValue(String key) {
		return mPref.getBoolean(key, false);
	}

	// 获取Boolean类型的值
	public Boolean getBooleanValueDefaultTrue(String key) {
		return mPref.getBoolean(key, true);
	}

	// 设置Boolean类型的值到配置文件
	public void setIntValue(String key, int value) {
		mPref.edit().putInt(key, value).commit();
	}	

	// 设置String类型的值到配置文件
	public void setStringValue(String key, String value) {
		mPref.edit().putString(key, value).commit();
	}

	// 设置float类型的值到配置文件
	public void setFloatValue(String key, float value) {
		mPref.edit().putFloat(key, value).commit();
	}

	// 设置long类型的值到配置文件
	public void setLongValue(String key, long value) {
		mPref.edit().putLong(key, value).commit();
	}

	// 设置boolean类型的值到配置文件
	public void setBooleanValue(String key, boolean value) {
		mPref.edit().putBoolean(key, value).commit();
	}
	//请空配置文件
	public void clearPreference(){
		mPref.edit().clear().commit();
	}

	/*
	 * public setValue(String key,int type){ switch(type){ case
	 * PrefenceType.BOOLEAN:
	 * 
	 * 
	 * } }
	 * 
	 * public static enum PrefenceType { BOOLEAN, INT, LONG, FLOAT, STRING }
	 */
}
