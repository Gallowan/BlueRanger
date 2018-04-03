package com.example.gallo.scouthq1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import static com.example.gallo.scouthq1.R.id.login_join_btn;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(login_join_btn).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.login_join_btn:
                startActivity(new Intent(this, SignUpActivity.class));
                // Code to display a message to the screen (toast)
                //Context context = getApplicationContext();
                //CharSequence text = "Hello toast!";
                //int duration = Toast.LENGTH_SHORT;
                //Toast toast = Toast.makeText(context, text, duration);
                //toast.show();


        }
    }
}