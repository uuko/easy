package com.example.easy;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {
    private static  final  String PREFERENCE="uuko";
    private  static SharedPreferences sharedPreferences;
    private static SharedPreferences getSharedPreference(Context context){
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFERENCE, 0);
        }
        return sharedPreferences;
    }
    public String getString(Context context,String key,String defaltVal){
        return getSharedPreference(context).getString(key,defaltVal);
    }
    public void setString(Context context,String key,String value){
        sharedPreferences.edit().putString(key,value);
    }
}
