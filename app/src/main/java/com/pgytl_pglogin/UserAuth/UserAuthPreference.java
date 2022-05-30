package com.pgytl_pglogin.UserAuth;

import android.content.Context;
import android.content.SharedPreferences;

public class UserAuthPreference {

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    private static final String LOGIN_STATUS = "status";

    public UserAuthPreference(Context context){
        sharedPreferences = context.getSharedPreferences("user_auth",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void setLoginStatus(boolean status){
        editor.putBoolean(LOGIN_STATUS,status);
        editor.commit();
    }
    public boolean getLoginStatus(){
        return sharedPreferences.getBoolean(LOGIN_STATUS,false);
    }
}

