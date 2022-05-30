package com.pgytl_pglogin.UserAuth;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;
    // shared pref mode
    private int PRIVATE_MODE = 0;
    // Shared preferences file name
    private static final String PREF_NAME = "com.example.calculator";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_FIRST_TIME_HOME_LAUNCH = "IsFirstTimeHomeLaunch";
    private static final String USER_KEY="userKey";
    private static final String USER_NAME="userName";
    private static final String email="email";
    private static final String USER_PHONE="userPhone";
    private static final String USER_PARENT_PHONE="userParentPhone";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setemail(String email){
        editor.putString(email,email);
        editor.apply();
    }
    public String getEmail(){
        return pref.getString(email,"No key available");
    }
    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.apply();
    }
    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH,true);
    }
    public void setUserKey(String key){
        editor.putString(USER_KEY,key);
        editor.apply();
    }
    public String getUserKey(){
        return pref.getString(USER_KEY,"No key available");
    }

    public void setFirstTimeHomeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_HOME_LAUNCH,isFirstTime);
        editor.apply();
    }

    public boolean isFirstTimeHomeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_HOME_LAUNCH, true);
    }

    public void setUserName(String name){
        editor.putString(USER_NAME,name);
        editor.apply();
    }
    public String getUserName(){
        return pref.getString(USER_NAME,"No key available");
    }

    public void setUserPhone(String phone){
        editor.putString(USER_PHONE,phone);
        editor.apply();
    }
    public String getUserPhone(){
        return pref.getString(USER_PHONE,"No key available");
    }

    public void setUserParentPhone(String parentPhone){
        editor.putString(USER_PARENT_PHONE,parentPhone);
        editor.apply();
    }
    public String getUserParentPhone(){
        return pref.getString(USER_PARENT_PHONE,"No key available");
    }

}
