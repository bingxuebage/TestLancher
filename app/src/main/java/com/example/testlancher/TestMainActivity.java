package com.example.testlancher;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TestMainActivity extends AppCompatActivity {

    private AppCompatButton mTest1Btn;
    private AppCompatButton mTest2Btn;
    private ViewGroup mLineView;
    private ViewGroup mTopView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        mTest1Btn = findViewById(R.id.test1_btn);
        mTest2Btn = findViewById(R.id.test2_btn);
        mLineView = findViewById(R.id.ly2);
        mTopView = findViewById(R.id.top_view);


        mTest1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test1();
            }
        });
        mTest2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2();
            }
        });
        mTopView.getRootView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    @Subscribe
    public void onTe(MotionEvent ev) {
        dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    /**
     * Activity 传递事件调研
     **/
    private void test1() {
        startActivity(new Intent(this, TestMainSecondActivity.class));
    }

    private void test2() {
        mLineView.setBackgroundColor(Color.parseColor("#888888"));
    }


}
