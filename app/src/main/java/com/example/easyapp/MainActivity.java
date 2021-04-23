package com.example.easyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easyapp.activity.BaseActivity;
import com.example.easyapp.activity.LoginActivity;
import com.example.easyapp.activity.RegisterActivity;

public class MainActivity extends BaseActivity {
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(LoginActivity.class);
            }
        });

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(RegisterActivity.class);
            }
        });
    }
}