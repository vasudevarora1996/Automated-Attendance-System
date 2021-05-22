package com.example.vasudev.attendancesystem;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Marked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marked);
    }



    public void signout(View view){
        Toast.makeText(this, "Signing-Out", Toast.LENGTH_SHORT).show();

        Handler h = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Intent intent = new Intent(Marked.this,LoginActivity.class);
                Toast.makeText(Marked.this, "Sign-Out Successfully !!!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        };
        h.sendEmptyMessageDelayed(0,1500);


    }

    public void homepage(View view){
        Toast.makeText(this, "Re-Directing to Dashboard", Toast.LENGTH_SHORT).show();

        Handler h = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Intent intent = new Intent(Marked.this,Dashboard2.class);
                startActivity(intent);
            }
        };
        h.sendEmptyMessageDelayed(0,1500);

    }
}
