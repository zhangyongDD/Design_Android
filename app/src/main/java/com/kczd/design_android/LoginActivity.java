package com.kczd.design_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kczd.core.ActionCallbackListener;

public class LoginActivity extends KBaseActivity {

    private EditText phoneEdit;
    private EditText passwordEdit;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 初始化View
        initViews();
    }
    // 初始化View
    private void initViews() {
        phoneEdit = (EditText) findViewById(R.id.edit_phone);
        passwordEdit = (EditText) findViewById(R.id.edit_password);
        loginBtn = (Button) findViewById(R.id.btn_login);
    }

    // 准备登录
    public void toLogin(View view) {
        String loginName = phoneEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        loginBtn.setEnabled(false);
        this.appAction.login(loginName, password, new ActionCallbackListener<Void>() {
            @Override
            public void onSuccess(Void data) {
                Toast.makeText(context, R.string.toast_login_success, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(String errorEvent, String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                loginBtn.setEnabled(true);
            }
        });
    }

    // 进入注册页
    public void toRegister(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
