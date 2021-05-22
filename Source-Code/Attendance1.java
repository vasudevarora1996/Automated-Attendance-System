package com.example.vasudev.attendancesystem;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Attendance1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance1);
    }

    @Override
    public void onBackPressed(){
        Toast.makeText(this, "Sorry, You Can't Go Back !!!", Toast.LENGTH_SHORT).show();

    }


    public void mark(View view)
    {
        Intent intent = new Intent(this,Mark.class);
        startActivity(intent);

    }

    public void view(View view){
        Intent intent = new Intent(this,VolleyMainActivity.class);
        startActivity(intent);

    }
    public void dashboard(View view){
        Toast.makeText(this, "Re-Directing To Dashboard !!!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Dashboard2.class);
        startActivity(intent);
    }

    public void homepage(View view){
        Toast.makeText(this, "Signing-Out", Toast.LENGTH_SHORT).show();

        Handler h = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Intent intent = new Intent(Attendance1.this,LoginActivity.class);
                Toast.makeText(Attendance1.this, "Sign-Out Successfully !!!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        };
        h.sendEmptyMessageDelayed(0,1500);



    }


}

