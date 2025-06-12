package com.ksivlay.hotelmobileapplication.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.ksivlay.hotelmobileapplication.contants.Constants;
import com.ksivlay.hotelmobileapplication.models.User;

public class UserSharePrefrence {
    public static void saveUserAccess(User user, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.UER_MODE, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.ID, user.getId());
        editor.putString(Constants.USER_NAME, user.getUserName());
        editor.putString(Constants.EMAIL, user.getEmail());
        editor.putString(Constants.PHONE, user.getEmail());
        editor.apply();
    }

    public static User getUerAccess(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.UER_MODE, 0);
        User user = new User();
        user.setId(sharedPreferences.getInt(Constants.ID, 0));
        user.setUserName(sharedPreferences.getString(Constants.USER_NAME, ""));
        user.setEmail(sharedPreferences.getString(Constants.EMAIL, ""));
        user.setPhone(sharedPreferences.getString(Constants.PHONE, ""));

        return user;
    }

    public static boolean checkLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.UER_MODE, 0);
        String username = sharedPreferences.getString(Constants.USER_NAME, "");
        return !username.isEmpty();
    }

    public static void clearUserAccess(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.UER_MODE, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Constants.ID);
        editor.remove(Constants.USER_NAME);
        editor.remove(Constants.EMAIL);
        editor.remove(Constants.PHONE);
        editor.apply();
    }

}
