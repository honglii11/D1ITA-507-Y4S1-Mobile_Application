package com.ksivlay.hotelmobileapplication.utils;

import android.content.Context;
import android.widget.Toast;

public class MessageUtils {
    public static void showToastMessage(Context context,String mss){
        Toast.makeText(context,mss,Toast.LENGTH_LONG).show();
    }
}
