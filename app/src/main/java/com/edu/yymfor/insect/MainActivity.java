package com.edu.yymfor.insect;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import tools.ToolsFor;

public class MainActivity extends AppCompatActivity {
    private ToolsFor tf = new ToolsFor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputLayout user_wrapper = (TextInputLayout) findViewById(R.id.widget_user);
        TextInputLayout pwd_wrapper = (TextInputLayout) findViewById(R.id.widget_pwd);
        user_wrapper.setHint("用户名");
        pwd_wrapper.setHint("密码");
        Button login_btn = (Button) findViewById(R.id.btn_log);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyBoard();
                String user_name = user_wrapper.getEditText().getText().toString();
                if(tf.validateMoudle().isEmailAdress(user_name)){
                    doLogin();
                    Intent in = new Intent(MainActivity.this, WelcomeActivity.class);
                    in.putExtra("data", "hello welcome");
                    startActivity(in);
                }else{
                    user_wrapper.setError("请输入正确邮箱地址");
                }

            }
        });
    }
    private void hideKeyBoard(){
        View v  = getCurrentFocus();
        if(v != null){
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    private void doLogin(){
        Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_SHORT).show();
    }
}
