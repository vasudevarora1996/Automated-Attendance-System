package com.example.vasudev.attendancesystem;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    public ProgressBar pgsBar;
    public Button login;
    public TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        pgsBar =findViewById(R.id.progressBar2);
        login = findViewById(R.id.button2);
        textView=findViewById(R.id.textView3);

        TextView tv=findViewById(R.id.textView2);
        tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);


    }

    public void exit(View view){

        Toast.makeText(this, "Exiting The Application !!!", Toast.LENGTH_SHORT).show();
        Handler h = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                finishAffinity();
                System.exit(0);
                }
        };
        h.sendEmptyMessageDelayed(0, 1500);

    }

    public void login(View view)
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void aboutus(View view){
        Intent intent = new Intent(this,About.class);
        startActivity(intent);

    }

    public void happenings(View view){
        Intent intent = new Intent(this,Happening.class);
        startActivity(intent);


    }

    public void contactus(View view){
        Intent intent = new Intent(this,Contact.class);
        startActivity(intent);


    }

    public void admin(View view){
        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You Can't Go Back", Toast.LENGTH_SHORT).show();
    }
}
