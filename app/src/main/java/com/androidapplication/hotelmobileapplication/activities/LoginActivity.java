package com.ksivlay.hotelmobileapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ksivlay.hotelmobileapplication.R;
import com.ksivlay.hotelmobileapplication.contants.Constants;
import com.ksivlay.hotelmobileapplication.data.local.UserSharePrefrence;
import com.ksivlay.hotelmobileapplication.models.User;
import com.ksivlay.hotelmobileapplication.utils.MessageUtils;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
    }

    private void initView(){
        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(username.isEmpty()){
            MessageUtils.showToastMessage(this,"Please Enter Username");
            return;
        }
        if(password.isEmpty()){
            MessageUtils.showToastMessage(this,"Please Enter Password");
            return;
        }
        if(!username.equals(Constants.USER_NAME_DB_LOCAL)){
            MessageUtils.showToastMessage(this,"Invalid username!");
            return;
        }
        if(!password.equals(Constants.USER_PASSWORD_DB_LOCAL)){
            MessageUtils.showToastMessage(this,"Invalid password!");
            return;
        }

        MessageUtils.showToastMessage(this,"Login Successfully");
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        UserSharePrefrence.saveUserAccess(user,this );
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }




}