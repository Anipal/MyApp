package com.example.shourya.myapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;


public class Signup extends AppCompatActivity {

    private EditText inputEmail, inputPassword;

    private ProgressBar progressBar;

    private EditText inputName, inputAge, inputUname;
    private static final String TAG = "Signup";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String LOG_TAG = Signup.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.Pa);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        inputName = (EditText) findViewById(R.id.name);
        inputAge = (EditText) findViewById(R.id.age);
        inputUname = (EditText) findViewById(R.id.Un);

        mAuth = FirebaseAuth.getInstance();


    }



    public void Signuponclick(View v) {
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

        ;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent intent = new Intent(Signup.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if (!task.isSuccessful()) {
                            Toast.makeText(Signup.this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}