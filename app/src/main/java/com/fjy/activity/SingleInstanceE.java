package com.fjy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleInstanceE extends BaseActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn1:
                intent = new Intent(SingleInstanceE.this,StandardB.class);
                intent.putExtra("msg","SingleInstanceE -> StandardB");
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(SingleInstanceE.this,SingleTopC.class);
                intent.putExtra("msg","SingleInstanceE -> SingleTopC");
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(SingleInstanceE.this,SingleTaskD.class);
                intent.putExtra("msg","SingleInstanceE -> SingleTaskD");
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(SingleInstanceE.this,SingleInstanceE.class);
                intent.putExtra("msg","SingleInstanceE -> SingleInstanceE");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
