package com.example.gallo.scouthq1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.gallo.scouthq1.R.id.btn_baseball;
import static com.example.gallo.scouthq1.R.id.btn_basketball_f;
import static com.example.gallo.scouthq1.R.id.btn_basketball_m;
import static com.example.gallo.scouthq1.R.id.btn_football;
import static com.example.gallo.scouthq1.R.id.btn_soccer_f;
import static com.example.gallo.scouthq1.R.id.btn_soccer_m;
import static com.example.gallo.scouthq1.R.id.btn_volleyball_f;
import static com.example.gallo.scouthq1.R.id.btn_volleyball_m;

public class SportsSelection extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_selection);
        findViewById(btn_basketball_m).setOnClickListener(this);
        findViewById(btn_basketball_f).setOnClickListener(this);
        findViewById(btn_baseball).setOnClickListener(this);
        findViewById(btn_football).setOnClickListener(this);
        findViewById(btn_soccer_m).setOnClickListener(this);
        findViewById(btn_soccer_f).setOnClickListener(this);
        findViewById(btn_volleyball_f).setOnClickListener(this);
        findViewById(btn_volleyball_m).setOnClickListener(this);
    }

    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_basketball_m:
                Intent myIntent = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent.putExtra("urlString", "https://www.ncaa.com/news/basketball-men/d1/rss.xml");
                SportsSelection.this.startActivity(myIntent);
                break;
            case R.id.btn_basketball_f:
                Intent myIntent2 = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent2.putExtra("urlString", "https://www.ncaa.com/news/basketball-women/d1/rss.xml");
                SportsSelection.this.startActivity(myIntent2);
                break;
            case R.id.btn_baseball:
                Intent myIntent3 = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent3.putExtra("urlString", "https://www.ncaa.com/news/baseball/d1/rss.xml");
                SportsSelection.this.startActivity(myIntent3);
                break;
            case R.id.btn_football:
                Intent myIntent4 = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent4.putExtra("urlString", "https://www.ncaa.com/news/football/fbs/rss.xml");
                SportsSelection.this.startActivity(myIntent4);
                break;
            case R.id.btn_soccer_m:
                Intent myIntent5 = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent5.putExtra("urlString", "https://www.ncaa.com/news/soccer-men/d1/rss.xml");
                SportsSelection.this.startActivity(myIntent5);
                break;
            case R.id.btn_soccer_f:
                Intent myIntent6 = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent6.putExtra("urlString", "https://www.ncaa.com/news/soccer-women/d1/rss.xml");
                SportsSelection.this.startActivity(myIntent6);
                break;
            case R.id.btn_volleyball_f:
                Intent myIntent7 = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent7.putExtra("urlString", "https://www.ncaa.com/news/volleyball-women/d1/rss.xml");
                SportsSelection.this.startActivity(myIntent7);
                break;
            case R.id.btn_volleyball_m:
                Intent myIntent8 = new Intent(SportsSelection.this, NewsFeed.class);
                myIntent8.putExtra("urlString", "https://www.ncaa.com/news/volleyball-men/nc/rss.xml");
                SportsSelection.this.startActivity(myIntent8);
                break;
        }
    }
}
