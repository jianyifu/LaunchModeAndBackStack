package com.fjy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StandardB extends BaseActivity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn1:
                intent = new Intent(StandardB.this,StandardB.class);
                intent.putExtra("msg","StandardB -> StandardB");
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(StandardB.this,SingleTopC.class);
                intent.putExtra("msg","StandardB -> SingleTopC");
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(StandardB.this,SingleTaskD.class);
                intent.putExtra("msg","StandardB -> SingleTaskD");
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(StandardB.this,SingleInstanceE.class);
                intent.putExtra("msg","StandardB -> SingleInstanceE");
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(StandardB.this,SingleTopC.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("msg","StandardB -> SingleTopC FLAG_ACTIVITY_NEW_TASK");
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
