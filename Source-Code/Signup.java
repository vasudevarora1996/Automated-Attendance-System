package com.example.vasudev.attendancesystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Signup extends AppCompatActivity {

    public  SQLiteDatabase db;
    EditText first,last,email,user,pass;
    public String first1,last1,user1,email1,pass1;
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    public int selected;
    public String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        first= findViewById(R.id.editText);
        last= findViewById(R.id.editText2);
        user= findViewById(R.id.editText3);
        email= findViewById(R.id.email11);
        pass= findViewById(R.id.editText9);
        radioGroup=findViewById(R.id.radioGroup22);
        db();
    }



    public void db(){
        db=openOrCreateDatabase("AttendanceSystem", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS AttendanceStudent(first VARCHAR,last VARCHAR,username VARCHAR,password VARCHAR,email VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS AttendanceFaculty(first VARCHAR,last VARCHAR,username VARCHAR,password VARCHAR,email VARCHAR);");

    }

    public void sign(View v) {
        first1 = first.getText().toString().trim();
        last1 = last.getText().toString().trim();
        email1 = email.getText().toString().trim();
        pass1 = pass.getText().toString().trim();
        user1 = user.getText().toString().trim();
        selected=radioGroup.getCheckedRadioButtonId();


        if (selected==R.id.radioButton3) {

            if (first1.equals("") || last1.equals("") || email1.equals("") || pass1.equals("") || user1.equals("")) {
                show("Error", "Field is Empty");
            } else {
                try {
                    db.execSQL("INSERT INTO AttendanceStudent VALUES('" + first1 + "','" + last1 + "','" + user1 + "','" + pass1 + "','" + email1 + "');");
                    Intent ij = new Intent(Signup.this, LoginActivity.class);
                    startActivity(ij);
                    show("Success", "Sign up Successfully");
                } catch (Exception e) {
                    show("Error", "cant sign up");
                }

            }


        }
        else if (selected==R.id.radioButton4){
            if (first1.equals("") || last1.equals("") || email1.equals("") || pass1.equals("") || user1.equals("")) {
                show("Error", "Field is Empty");
            } else {
                try {
                    db.execSQL("INSERT INTO AttendanceFaculty VALUES('" + first1 + "','" + last1 + "','" + user1 + "','" + pass1 + "','" + email1 + "');");
                    Intent ij = new Intent(Signup.this, LoginActivity.class);
                    startActivity(ij);
                    show("Success", "Sign up Successfully");
                } catch (Exception e) {
                    show("Error", "cant sign up");
                }

            }
        }
        else {
            show("Error","Select Type of User");
        }




    }
    public void show(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}

