package com.example.easyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easyapp.R;
import com.example.easyapp.api.Api;
import com.example.easyapp.api.ApiConfig;
import com.example.easyapp.api.TtitCallback;
import com.example.easyapp.entity.LoginResponse;
import com.example.easyapp.util.AppConfig;
import com.example.easyapp.util.StringUtils;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                login(account, pwd);
            }
        });

    }

    private void login(String account, String pwd) {
        if (StringUtils.isEmpty(account)) {
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("mobile", account);
        params.put("password", pwd);
        Api.config(ApiConfig.LOGIN, params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                System.out.println(res);
                Gson gson = new Gson();
                LoginResponse loginResponse = gson.fromJson(res, LoginResponse.class);
                if (loginResponse.getCode() == 0) {
                    String token = loginResponse.getToken();
//                    SharedPreferences sp = getSharedPreferences("sp_ttit", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sp.edit();
//                    editor.putString("token", token);
//                    editor.apply();
                    saveStringToSp("token", token);
                    //navigateTo(HomeActivity.class);
                    showToastSync("登录成功");
                } else {
                    showToastSync("登陆失败");
                }
            }

            @Override
            public void onFailure(Exception e) {
                showToast("登陆失败");
            }
        });
    }


}