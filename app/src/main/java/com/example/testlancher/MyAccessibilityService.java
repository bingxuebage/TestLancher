package com.example.testlancher;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends AccessibilityService {

    private String TAG = "JUN_MyAccessibilityService";

//    @Override
//    public void onCreate() {
//        getServiceInfo().flags = AccessibilityServiceInfo.FLAG_REQUEST_TOUCH_EXPLORATION_MODE;
//        super.onCreate();
//
//    }

    @Override
    protected void onServiceConnected() {
        Log.d(TAG, "onServiceConnected+++++");
        super.onServiceConnected();
    }

//    @Override
//    protected boolean onGesture(int gestureId) {
//        Log.v(TAG, String.format("onGesture: [type] %s", gIdToString(gestureId)));
//        return false;
//    }

//    /**
//     * Converts gestureID to a representative String
//     *
//     * @param gID
//     * @return
//     */
//    private String gIdToString(int gID) {
//        switch (gID) {
//            case 1:
//                return "GESTURE_SWIPE_UP";
//            case 2:
//                return "GESTURE_SWIPE_DOWN";
//            case 3:
//                return "GESTURE_SWIPE_LEFT";
//            case 4:
//                return "GESTURE_SWIPE_RIGHT";
//            case 5:
//                return "GESTURE_SWIPE_LEFT_AND_RIGHT";
//            case 6:
//                return "GESTURE_SWIPE_RIGHT_AND_LEFT";
//            case 7:
//                return "GESTURE_SWIPE_UP_AND_DOWN";
//            case 8:
//                return "GESTURE_SWIPE_DOWN_AND_UP";
//            case 9:
//                return "GESTURE_SWIPE_LEFT_AND_UP";
//            case 10:
//                return "GESTURE_SWIPE_LEFT_AND_DOWN";
//            case 11:
//                return "GESTURE_SWIPE_RIGHT_AND_UP";
//            case 12:
//                return "GESTURE_SWIPE_RIGHT_AND_DOWN";
//            case 13:
//                return "GESTURE_SWIPE_UP_AND_LEFT";
//            case 14:
//                return "GESTURE_SWIPE_UP_AND_RIGHT";
//            case 15:
//                return "GESTURE_SWIPE_DOWN_AND_LEFT";
//            case 16:
//                return "GESTURE_SWIPE_DOWN_AND_RIGHT";
//        }
//        return "UNKNOWN";
//    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        String packageName = event.getPackageName().toString();
        Log.d(TAG, event.getPackageName().toString() + event.getEventType());
        int eventType = event.getEventType();
        String eventText = "";

        switch (eventType) {
            case AccessibilityEvent.TYPE_GESTURE_DETECTION_START:
                eventText = "TYPE_GESTURE_DETECTION_START";
                break;
            case AccessibilityEvent.TYPE_GESTURE_DETECTION_END:
                eventText = "TYPE_GESTURE_DETECTION_END";
                break;
        }
        if (!TextUtils.isEmpty(eventText)) {
            Log.i(TAG, "==============Start====================");
            eventText = eventText + ":" + eventType;
            Log.i(TAG, eventText);
            Log.i(TAG, "=============END=====================");
        }


//        switch (event.getEventType()) {
//            case AccessibilityEvent.TYPE_GESTURE_DETECTION_START:
//                AccessibilityNodeInfo mNodeInfo = getRootInActiveWindow();
//                Rect rect = new Rect();
//                mNodeInfo.getBoundsInScreen(rect);
//                boolean isPerformed = mNodeInfo.performAction(GESTURE_SWIPE_RIGHT);
//                accessibilityNodeInfo = mNodeInfo;
//                traversalNodeInfo(mNodeInfo);
//                performLoveButtonClick(mLoveButton);
////                    performSwipeRight(mNodeInfo);
//                Log.d(TAG, "child counts is :" + mNodeInfo.getChildCount() + "\nrect is :" + rect.toString() + "\n performed is :" + isPerformed);
//                break;
//        }
    }


    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        Log.d(TAG, event.toString());
        return super.onKeyEvent(event);
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "onInterrupt+++++");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind+++++");
        return super.onUnbind(intent);
    }

}
