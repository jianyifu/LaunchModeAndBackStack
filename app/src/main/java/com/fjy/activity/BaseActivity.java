package com.fjy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    protected Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        dealWithIntent(intent, "onCreate");
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        dealWithIntent(intent, "onNewIntent");
    }

    protected void dealWithIntent(Intent intent, String from) {
        this.intent = intent;
        if (this.intent != null && intent.hasExtra("msg")) {
            String msg = intent.getStringExtra("msg");
            getTaskId();
            Log.d(TAG,String.format("dealWithIntent() called with: from = [%15s], " + "msg = [%30s], taskId = [%10d]",from,msg,getTaskId()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called ["+this.getClass().getSimpleName()+"]");
    }
}
