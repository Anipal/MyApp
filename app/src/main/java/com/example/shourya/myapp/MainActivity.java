package com.example.shourya.myapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.id;
import static android.R.attr.password;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void check(View view)
    {
        EditText username = (EditText)findViewById(R.id.Un);
        EditText password = (EditText)findViewById(R.id.Pa);

        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){

            Intent intent = new Intent(MainActivity.this, MAIN.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    public void forgot(View view)
    {
        Intent intent = new Intent(MainActivity.this, Forgot.class);
        startActivity(intent);
    }

    public void signup(View view)
    {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }
}
