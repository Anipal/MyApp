package com.example.shourya.myapp;



import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;


import static android.R.attr.id;
import static android.R.attr.password;

public class MainActivity extends AppCompatActivity {



    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, MAIN.class));
            finish();
        }


        setContentView(R.layout.activity_main);

        inputEmail = (EditText) findViewById(R.id.Un);
        inputPassword = (EditText) findViewById(R.id.Pa);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

    }


    public void onClick(View v) {
        String email = inputEmail.getText().toString();
        final String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                inputPassword.setError("Short Password");
                            } else {
                                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(MainActivity.this, MAIN.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }




    /* public void check(View view)
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
  */
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