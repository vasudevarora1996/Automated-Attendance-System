package com.example.vasudev.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        t1=findViewById(R.id.textView31);
        t2=findViewById(R.id.textView33);
        t3=findViewById(R.id.textView35);
        t4=findViewById(R.id.textView37);
        t1.setText(LoginActivity.name12);
        t2.setText(LoginActivity.reg12);
        t3.setText(LoginActivity.username12);
        t4.setText(LoginActivity.mobile12);






    }



}
