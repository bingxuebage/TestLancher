package com.example.testlancher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LauncherActivity extends AppCompatActivity {
    private AppCompatButton mTest1Btn;
    private AppCompatButton mTest2Btn;
    private AppCompatButton mTest3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancher);
        mTest1Btn = findViewById(R.id.button1);
        mTest2Btn = findViewById(R.id.button2);
        mTest3Btn = findViewById(R.id.button3);

        mTest1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, TestMainActivity.class));
            }
        });
        mTest2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, TestFloatActivity.class));
            }
        });
        mTest3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, TestAccessibilityActivity.class));
            }
        });
    }
}
