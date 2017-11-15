package com.fjy.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class SingleTopC extends BaseActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top_c);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn1:
                intent = new Intent(SingleTopC.this,SingleTopC.class);
                intent.putExtra("msg","SingleTopC -> SingleTopC");
                startActivity(intent);
                break;
            case R.id.btn2:
                sendNotification(SingleTopC.class);
                break;
            case R.id.btn3:
                intent = new Intent(SingleTopC.this,StandardB.class);
                intent.putExtra("msg","SingleTopC -> StandardB");
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(SingleTopC.this,SingleTaskD.class);
                intent.putExtra("msg","SingleTopC -> SingleTaskD");
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(SingleTopC.this,SingleInstanceE.class);
                intent.putExtra("msg","SingleTopC -> SingleInstanceE");
                startActivity(intent);
                break;
            case R.id.btn6:
                intent = new Intent(SingleTopC.this,StandardB.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("msg","SingleTopC -> StandardB FLAG_ACTIVITY_NEW_TASK");
                startActivity(intent);
                break;
            case R.id.btn7:
                sendNotification(SingleTaskD.class);
                break;
            case R.id.btn8:
                sendNotification(SingleInstanceE.class);
                break;
            default:
                break;
        }
    }
    // to send a notification,the click event is to open current activity
    private void sendNotification(Class clazz) {
        //获取NotificationManager实例
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化NotificationCompat.Builde并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                //设置小图标
                .setSmallIcon(R.mipmap.ic_launcher_round)
                //设置通知标题
                .setContentTitle("I am a msg to open "+clazz.getSimpleName())
                //设置通知内容
                .setContentText("content")
        .setWhen(System.currentTimeMillis());
        Notification noti = builder.build();
        Intent intent  =  new Intent(this,clazz);
        intent.putExtra("msg","Notification -> "+clazz.getSimpleName());
        PendingIntent contentIntent = PendingIntent.getActivity
                (SingleTopC.this, 0,intent, 0);
        noti.contentIntent = contentIntent;
        notifyManager.notify(new Long(System.currentTimeMillis()/1000).intValue(), noti);
    }

}
