package com.edu.yymfor.insect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yym on 2018/5/24.
 */

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent in = getIntent();
        TextView tv = (TextView) findViewById(R.id.wel);
        tv.setText(in.getStringExtra("data"));
    }
}
