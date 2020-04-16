package com.example.testlancher;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.MoveType;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.Screen;

public class BaseApplication extends Application {


    private static final String TAG = "FloatWindow";

    @Override
    public void onCreate() {
        super.onCreate();


        //initFloatWindow();


    }


    private void initFloatWindow() {

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.ic_launcher_background);

        FloatWindow
                .with(getApplicationContext())
                .setView(imageView)
                .setWidth(Screen.width, 0.2f) //设置悬浮控件宽高
                .setHeight(Screen.width, 0.2f)
                .setX(Screen.width, 0.8f)
                .setY(Screen.height, 0.3f)
                .setMoveType(MoveType.inactive, 10, -100)
                .setMoveStyle(500, new BounceInterpolator())
                .setFilter(true, TestMainActivity.class)
                //.setViewStateListener(mViewStateListener)
                .setPermissionListener(mPermissionListener)
                .setDesktopShow(false)//桌面显示
                .setTag("jun")
                .build();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseApplication.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private PermissionListener mPermissionListener = new PermissionListener() {
        @Override
        public void onSuccess() {
            Log.d(TAG, "onSuccess");
        }

        @Override
        public void onFail() {
            Log.d(TAG, "onFail");
        }
    };

//    private ViewStateListener mViewStateListener = new ViewStateListener() {
//        @Override
//        public void onPositionUpdate(int x, int y) {
//            Log.d(TAG, "onPositionUpdate: x=" + x + " y=" + y);
//        }
//
//        @Override
//        public void onShow() {
//            Log.d(TAG, "onShow");
//        }
//
//        @Override
//        public void onHide() {
//            Log.d(TAG, "onHide");
//        }
//
//        @Override
//        public void onDismiss() {
//            Log.d(TAG, "onDismiss");
//        }
//
//        @Override
//        public void onMoveAnimStart() {
//            Log.d(TAG, "onMoveAnimStart");
//        }
//
//        @Override
//        public void onMoveAnimEnd() {
//            Log.d(TAG, "onMoveAnimEnd");
//        }
//
//        @Override
//        public void onBackToDesktop() {
//            Log.d(TAG, "onBackToDesktop");
//        }
//    };
}