package com.ksivlay.hotelmobileapplication.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.ksivlay.hotelmobileapplication.data.local.UserSharePrefrence;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        if(UserSharePrefrence.checkLogin(this) == false){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
