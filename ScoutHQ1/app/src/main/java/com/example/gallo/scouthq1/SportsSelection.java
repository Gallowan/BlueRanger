package com.example.gallo.scouthq1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.gallo.scouthq1.R.id.btn_basketball_m;

public class SportsSelection extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_selection);
        findViewById(btn_basketball_m).setOnClickListener(this);
    }

    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_basketball_m:
                Intent myIntent = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent);
            case R.id.btn_basketball_f:
                Intent myIntent2 = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent2);
            case R.id.btn_baseball:
                Intent myIntent3 = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent3);
            case R.id.btn_football:
                Intent myIntent4 = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent4);
            case R.id.btn_soccer_m:
                Intent myIntent5 = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent5);
            case R.id.btn_soccer_f:
                Intent myIntent6 = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent6);
            case R.id.btn_volleyball_f:
                Intent myIntent7 = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent7);
            case R.id.btn_volleyball_m:
                Intent myIntent8 = new Intent(SportsSelection.this, NewsFeed.class);
                SportsSelection.this.startActivity(myIntent8);
        }
    }
}
