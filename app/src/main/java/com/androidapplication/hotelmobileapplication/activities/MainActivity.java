package com.ksivlay.hotelmobileapplication.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.graphics.ShaderKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ksivlay.hotelmobileapplication.R;
import com.ksivlay.hotelmobileapplication.data.local.UserSharePrefrence;

public class MainActivity extends BaseActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSharePrefrence.clearUserAccess(MainActivity.this);
                MainActivity.super.onResume();
            }
        });
    }

}