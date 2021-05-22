package com.example.vasudev.attendancesystem;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard2 extends AppCompatActivity {


    private TextView namedisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        namedisplay=findViewById(R.id.textView23);
        namedisplay.setText(""+LoginActivity.name12);
        namedisplay.setPaintFlags(namedisplay.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        TextView tv=findViewById(R.id.textView2);
        tv.setPaintFlags(tv.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

        }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Sorry, You Can't Go Back !!!", Toast.LENGTH_SHORT).show();
    }

    public void AttendanceModule(View view)
    {
        Intent intent = new Intent(this,Attendance1.class);
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

    public void profile(View view){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);


    }

    public void admin(View view){
        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }

    public void homepage(View view){
        Toast.makeText(this, "Signing-Out", Toast.LENGTH_SHORT).show();

        Handler h = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Intent intent = new Intent(Dashboard2.this,LoginActivity.class);
                Toast.makeText(Dashboard2.this, "Sign-Out Successfully !!!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        };
        h.sendEmptyMessageDelayed(0,1500);



    }

}
