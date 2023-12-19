package com.friends.catdiary;

import android.app.Activity;
import android.widget.Toast;

public class BackKeyHandler {

    private long backKeyPressedTime = 0;
    private final Activity activity;
    private Toast toast;

    public BackKeyHandler(Activity activity) {
        this.activity = activity;
    }

    public void onBackPressed(String msg, double time) {
        if (System.currentTimeMillis() > backKeyPressedTime + (time * 1000)) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide(msg);
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }

    private void showGuide() {
        toast = Toast.makeText(activity, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void showGuide(String msg) {
        toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}