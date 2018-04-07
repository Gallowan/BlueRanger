package com.example.gallo.scouthq1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.gallo.scouthq1.R.id.btn_login_join;
import static com.example.gallo.scouthq1.R.id.btn_login;
import static com.example.gallo.scouthq1.R.id.btn_news_feed;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editLoginEmail, editLoginPassword;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState)
    {

        editLoginEmail = (EditText) findViewById(R.id.field_login_email_address);
        editLoginPassword = (EditText) findViewById(R.id.field_login_password);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //"Join for Free" Button
        findViewById(btn_login_join).setOnClickListener(this);

        //Login Button
        findViewById(btn_login).setOnClickListener(this);

        //News Feed Button
        findViewById(btn_news_feed).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    private void userLogin()
    {
        String emailLogin = editLoginEmail.getText().toString().trim();
        String passwordLogin = editLoginPassword.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(emailLogin).matches())
        {
            editLoginEmail.setError("Please enter a valid email address");
            editLoginEmail.requestFocus();
            return;
        }
        if(emailLogin.isEmpty())
        {
            editLoginEmail.setError("Email is required.");
            editLoginEmail.requestFocus();
            return;
        }

        if(passwordLogin.isEmpty())
        {
            editLoginPassword.setError("Password is required.");
            editLoginPassword.requestFocus();
            return;
        }

        if(passwordLogin.length() < 6)
        {
            editLoginPassword.setError("Not enough characters for password");
            editLoginPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(emailLogin, passwordLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "User login successful!", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(LoginActivity.this, NewsFeed.class);
                    myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(myIntent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            // Login button
            case R.id.btn_login:
                userLogin();
                break;
            // Sign up for free button
            case R.id.btn_login_join:
                Intent joinIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                LoginActivity.this.startActivity(joinIntent);
                break;
            // Login button
            case R.id.btn_news_feed:
                Intent newsFeedIntent = new Intent(LoginActivity.this, NewsFeed.class);
                LoginActivity.this.startActivity(newsFeedIntent);
                break;

        }
    }
}