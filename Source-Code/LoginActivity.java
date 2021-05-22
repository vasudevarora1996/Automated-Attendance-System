package com.example.vasudev.attendancesystem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public SQLiteDatabase db;
    public int selected;
    public static String name12,reg12,username12,mobile12;
    EditText user,pass;
    String user1,pass1;
    TextView tv;
    public RadioButton radioButton;
    public RadioGroup radioGroup;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.user11);
        pass=findViewById(R.id.password11);
        tv=findViewById(R.id.textView10);
        tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        db();
        }

    int x=0;
    @Override
    public void onBackPressed(){
        Toast.makeText(this, "Sorry, You Can't Go Back", Toast.LENGTH_SHORT).show();
    }

    public void showpassword(View view){
        x++;
        if (x%2==1) pass.setTransformationMethod(null);

        else pass.setTransformationMethod(new PasswordTransformationMethod());
    }

    public void db(){

        db=openOrCreateDatabase("AttendanceSystem", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS AttendanceStudent(first VARCHAR,last VARCHAR,username VARCHAR ,password VARCHAR,email VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS AttendanceFaculty(first VARCHAR,last VARCHAR,username VARCHAR ,password VARCHAR,email VARCHAR);");

        radioGroup=findViewById(R.id.radioGroup11);

    }
    public void login(View xyz) {
        user1 = user.getText().toString().trim();
        pass1 = pass.getText().toString().trim();

        selected=radioGroup.getCheckedRadioButtonId();

        if (user1.equals("") || pass1.equals("")) {
            show("Empty", "Field is Empty");

        } else {
            if (selected==R.id.radioButton) {
                try {


                    Cursor c = db.rawQuery("SELECT * FROM AttendanceStudent WHERE username='" + user1 + "'", null);
                    if (c.moveToFirst()) {
                        if (pass1.equals(c.getString(3))) {
                            show("Success", "Logged In Successfully");
                            name12 = c.getString(0);
                            reg12 = c.getString(1);
                            username12 = c.getString(2);
                            mobile12 = c.getString(4);

                            Handler h = new Handler() {
                                @Override
                                public void handleMessage(Message msg) {
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    i.putExtra("name", name12);
                                    startActivity(i);

                                }
                            };
                            h.sendEmptyMessageDelayed(0, 1500);
                        } else {
                            show("Login Failed", "Password is not matched");
                        }
                    } else {
                        show("Login Failed", "Entered Details are Incorrect");

                    }
                } catch (Exception ee) {
                    show("Error", "Cant Login");
                }


            }
            else if (selected==R.id.radioButton2){
                    try {


                        Cursor c = db.rawQuery("SELECT * FROM AttendanceFaculty WHERE username='" + user1 + "'", null);
                        if (c.moveToFirst()) {
                            if (pass1.equals(c.getString(3))) {
                                show("Success", "Logged In Successfully");
                                name12 = c.getString(0);
                                reg12 = c.getString(1);
                                username12 = c.getString(2);
                                mobile12 = c.getString(4);

                                Handler h = new Handler() {
                                    @Override
                                    public void handleMessage(Message msg) {
                                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                        i.putExtra("name", name12);
                                        startActivity(i);

                                    }
                                };
                                h.sendEmptyMessageDelayed(0, 1500);
                            } else {
                                show("Login Failed", "Password is not matched");
                            }
                        } else {
                            show("Login Failed", "Entered Details are Incorrect");

                        }
                    } catch (Exception ee) {
                        show("Error", "Cant Login");
                    }


                }
                else {
                show("Error","Please Select Type of User");
            }
            }

        }


    public void signup(View z){
        Intent k=new Intent(this,Signup.class);
        startActivity(k);
    }

    public void dashboard(View view){
        Toast.makeText(this, "Welcome To Dashboard !!!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Dashboard.class);
        startActivity(intent);
    }

    public void show(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_login, menu);
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
