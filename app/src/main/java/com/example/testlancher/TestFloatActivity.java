package com.example.testlancher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.interfaces.OnInvokeView;
import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.IFloatWindow;

public class TestFloatActivity extends AppCompatActivity {
    private AppCompatButton mTest1Btn;
    private AppCompatButton mTest2Btn;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_float);

        mTest1Btn = findViewById(R.id.test1_btn);
        mTest2Btn = findViewById(R.id.test2_btn);
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
        mGestureDetector = new GestureDetector(TestFloatActivity.this, new GestureListenerImpl());
    }

    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    //以下为OnGestureListener的实现
    private class GestureListenerImpl implements GestureDetector.OnGestureListener {
        //触摸屏幕时均会调用该方法
        @Override
        public boolean onDown(MotionEvent e) {
            //System.out.println("---> 手势中的 onDown 方法");
            return false;
        }

        //手指在屏幕上拖动时会调用该方法
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            System.out.println("---> 手势中的 onFling 方法");
            System.out.println("e1.getAction()=" + e1.getAction() + ",e2.getAction()=" + e2.getAction());
            System.out.println("velocityX=" + velocityX + ",velocityY=" + velocityY);
            if (Math.abs(velocityX) > 100) {
                showNegativeScreen();
            }
            return false;
        }

        //长按触摸屏幕时均会调用该方法
        @Override
        public void onLongPress(MotionEvent e) {
            //System.out.println("---> 手势中的 onLongPress 方法");
        }

        //手指在屏幕上滚动时会调用该方法
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            System.out.println("---> 手势中的 onScroll 方法");
//            System.out.println("e1.getAction()=" + e1.getAction() + ",e2.getAction()=" + e2.getAction());
//            System.out.println("distanceX=" + distanceX + ",distanceY=" + distanceY);
            return false;
        }

        //在触摸屏上按下,且未移动和松开时调用该方法
        @Override
        public void onShowPress(MotionEvent e) {
            //System.out.println("---> 手势中的 onShowPress 方法");
        }

        //轻击屏幕时调用该方法
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            //System.out.println("---> 手势中的 onSingleTapUp 方法");
            return false;
        }
    }


    /**
     * 悬浮窗调研
     **/
    private void test1() {
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 0);
        } else {
            startService(new Intent(TestFloatActivity.this, MyFloatWindowService.class));
        }

    }

    /**
     * 悬浮窗调研
     **/
    private void test2() {
        showNegativeScreen();
    }

    private void showNegativeScreen() {
        IFloatWindow floatWindow = FloatWindow.get("jun");
        if (floatWindow != null) {
            if (floatWindow.isShowing()) {
                floatWindow.hide();
            } else {
                floatWindow.show();
            }
        } else {
            EasyFloat.with(this)
                    .setTag("showNegativeScreen")
                    .setShowPattern(ShowPattern.FOREGROUND)
                    .setGravity(Gravity.LEFT, 0, 0)
                    .setMatchParent(true, true)
                    .setDragEnable(false)
//                .setAnimator(new DefaultAnimator() {
//                    @Override
//                    public Animator enterAnim(View view, ViewGroup parentView, SidePattern sidePattern) {
//                        Animator animator = super.enterAnim(view, parentView, sidePattern);
//                        //animator.setInterpolator(new BounceInterpolator());
//                        return animator;
//                    }
//
//                    @Override
//                    public Animator exitAnim(View view, ViewGroup parentView, SidePattern sidePattern) {
//                        return super.exitAnim(view, parentView, sidePattern);
//                    }
//                })
                    .setLayout(R.layout.float_negative, new OnInvokeView() {
                        @Override
                        public void invoke(View view) {

                            AppCompatButton mTestButton = view.findViewById(R.id.nav_show);
                            AppCompatButton mCloseButton = view.findViewById(R.id.nav_close);
                            mTestButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(TestFloatActivity.this, "点击我", Toast.LENGTH_LONG).show();
                                }
                            });
                            mCloseButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    closeNegativeScreen();
                                }
                            });

                        }
                    }).show();
        }
    }

    void closeNegativeScreen() {
        EasyFloat.dismissAppFloat("showNegativeScreen");
    }


}
