package com.example.testlancher;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import org.greenrobot.eventbus.EventBus;

public class TestMainSecondActivity extends AppCompatActivity {
    private AppCompatButton mTest1Btn;
    private AppCompatButton mTest2Btn;
    private ViewGroup mTopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        mTest1Btn = findViewById(R.id.test1_btn);
        mTest2Btn = findViewById(R.id.test2_btn);
        mTopView = findViewById(R.id.top_view);

        mTest1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move();
            }
        });
        mTest2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mTopView.getRootView().setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getX() < 200) {
                    EventBus.getDefault().post(event);
//                    Intent intent = new Intent();
//                    //设置广播的名字（设置Action）
//                    intent.setAction("voice_home");
//                    sendBroadcast(intent);
                }

//                // TODO Auto-generated method stub
//                switch(event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        System.out.println("---action down-----");
//                        Log.d("jun","起始位置为："+"("+event.getX()+" , "+event.getY()+")");
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        System.out.println("---action move-----");
//                        Log.d("jun","移动中坐标为："+"("+event.getX()+" , "+event.getY()+")");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        System.out.println("---action up-----");
//                        Log.d("jun","最后位置为："+"("+event.getX()+" , "+event.getY()+")");
//                }
                return true;
            }
        });
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getX() < 200) {
//            EventBus.getDefault().post(ev);
//            return true;
//        }
//        return true;
//    }

    private void move() {
        ObjectAnimator ra = ObjectAnimator.ofFloat(mTopView, "translationX", 0f, 500f);
        ra.setDuration(3000);
        ra.start();


    }
}
