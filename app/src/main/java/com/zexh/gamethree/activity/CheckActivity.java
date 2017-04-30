package com.zexh.gamethree.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zexh.gamethree.R;

public class CheckActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_next;
    private TextView tv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initView();
        initData();
        initListener();
    }
    private void initData() {

    }
    private void initListener() {
        tv_back.setOnClickListener(this);
        tv_next.setOnClickListener(this);
    }
    private void initView() {
        tv_back = (TextView) findViewById(R.id.text_back_check);
        tv_next = (TextView) findViewById(R.id.text_check);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_back_check:
                finish();
                break;
            case R.id.text_check:
                Intent showIntent = new Intent(CheckActivity.this,ShowActivity.class);
                startActivity(showIntent);
                break;
        }
    }
}
