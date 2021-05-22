package com.example.vasudev.attendancesystem;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Mark extends AppCompatActivity{

    Calendar calander;
    String ROOT_URL = "http://192.168.43.136//MyApi/get_data.php";
    String TempName, TempReg ;
    String hour;
    SimpleDateFormat simpledateformat,time_hour;
    String Date;
    TextView DisplayDateTime,lecture_hour,coursename,faculty12;

    String[] wed = {"INT 401","CSE 306","ENG 201","CSE 554","INT 301","INT 301","INT 301"};
    String[] faculty={"Dr.Rohit Sharma","Mr.Sahil Verma","Dr.Vinay Goel","Mr.Ram Kumar","Mr.Kamalpreet Singh","Dr.Rawinder Jadeja","Mr.Arjun Singh"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);

        TempName = LoginActivity.name12;
        TempReg = LoginActivity.reg12;

        DisplayDateTime = findViewById(R.id.textView22);
        lecture_hour = findViewById(R.id.textView21);
        coursename = findViewById(R.id.textView20);
        faculty12 = findViewById(R.id.textView27);

        calander = Calendar.getInstance();
        simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        time_hour = new SimpleDateFormat("HH");
        Date = simpledateformat.format(calander.getTime());

        SimpleDateFormat format = new SimpleDateFormat("HH", Locale.ENGLISH);
        hour = format.format(new Date());

        if (hour.equalsIgnoreCase("09")) {
            lecture_hour.setText("9 - 10 AM");
            coursename.setText(wed[0]);
            faculty12.setText("Taken By: " + faculty[0]);
        } else if (hour.equalsIgnoreCase("10")) {
            lecture_hour.setText("10 - 11 AM");
            coursename.setText(wed[1]);
            faculty12.setText("Taken By: " + faculty[1]);
        } else if (hour.equalsIgnoreCase("11")) {
            lecture_hour.setText("11 - 12 PM");
            coursename.setText(wed[2]);
            faculty12.setText("Taken By: " + faculty[2]);
        } else if (hour.equalsIgnoreCase("12")) {
            lecture_hour.setText("12 - 1 PM");
            coursename.setText(wed[3]);
            faculty12.setText("Taken By: " + faculty[3]);
        } else if (hour.equalsIgnoreCase("13")) {
            lecture_hour.setText("1 - 2 PM");
            coursename.setText("Lunch Break");
            faculty12.setText("Lunch Break");
        } else if (hour.equalsIgnoreCase("14")) {
            lecture_hour.setText("2 - 3 PM");
            coursename.setText(wed[4]);
            faculty12.setText("Taken By: " + faculty[4]);
        } else if (hour.equalsIgnoreCase("15")) {
            lecture_hour.setText("3 - 4 PM");
            coursename.setText(wed[5]);
            faculty12.setText("Taken By: " + faculty[5]);
        } else if (hour.equalsIgnoreCase("16")) {
            lecture_hour.setText("4 - 5 PM");
            coursename.setText(wed[6]);
            faculty12.setText("Taken By: " + faculty[6]);
        } else {
            lecture_hour.setText("No Class");
            coursename.setText("No Class");
            faculty12.setText("No Class");
        }


        DisplayDateTime.setText(Date);

        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()){
                    try{
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                calander = Calendar.getInstance();
                                simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                Date = simpledateformat.format(calander.getTime());
                                DisplayDateTime.setText(Date);
                            }
                        });

                        }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }

        };
        t.start();
    }



    public void otp(View view){
        Intent intent = new Intent(this,OtpAuthentication.class);
        startActivity(intent);
    }





}
