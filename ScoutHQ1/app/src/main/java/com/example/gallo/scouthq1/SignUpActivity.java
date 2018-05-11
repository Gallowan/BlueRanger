package com.example.gallo.scouthq1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{


    EditText editTextEmail, editTextPassword, getEditTextPasswordReenter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextEmail = (EditText) findViewById(R.id.field_sign_up_email_address);
        editTextPassword = (EditText) findViewById(R.id.field_sign_up_password);
        getEditTextPasswordReenter = (EditText) findViewById(R.id.field_password_reenter);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btn_join).setOnClickListener(this);
    }

    //Registers user to Firebase Database and test cases
    private void registerUser()
    {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String passwordReenter = getEditTextPasswordReenter.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Please enter a valid email address");
            editTextEmail.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required.");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            editTextPassword.setError("Password is required.");
            editTextPassword.requestFocus();
            return;
        }

        if(!password.equals(passwordReenter))
        {
            getEditTextPasswordReenter.setError("Password doesn't match");
            getEditTextPasswordReenter.requestFocus();
            return;
        }

        if(password.length() < 6)
        {
            editTextPassword.setError("Not enough characters for password");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "User registration successful!", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(SignUpActivity.this, NewsFeedOld.class);
                    myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(myIntent);
                }
                else
                {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(), "This user is already registered", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Some error occured dude idk tbh", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_join:
                registerUser();
                break;
        }
    }
}
