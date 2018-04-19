package com.example.gallo.scouthq1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Reader;

public class NewsFeed extends AppCompatActivity {

    private ListView mList;
    ArrayAdapter<String> adapter;
    OnSwipeTouchListener onSwipeTouchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mList = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this, R.layout.content_news_feed);
        new GetRssFeed().execute("http://www.espn.com/espn/rss/ncb/news");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        onSwipeTouchListener = new OnSwipeTouchListener(){
        //background.setOnTouchListener(new OnSwipeTouchListener(){
            public boolean onSwipeRight(){
                Intent myIntent = new Intent(NewsFeed.this, SportsSelection.class);
                NewsFeed.this.startActivity(myIntent);
                return true;

            }
            public boolean onSwipeLeft(){
                Intent myIntent = new Intent(NewsFeed.this, SportsSelection.class);
                NewsFeed.this.startActivity(myIntent);
                return true;
            }
        };
    }

    private class GetRssFeed extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                FeedReader feedReader = new FeedReader(params[0]);
                for (FeedSource item : feedReader.getItems())
                    adapter.add(item.getTitle());
            } catch (Exception e) {
                Log.v("Error Parsing Data", e + "");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
            mList.setAdapter(adapter);
        }
    }

    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.fab:
                Intent newsFeedIntent = new Intent(NewsFeed.this, SportsSelection.class);
                NewsFeed.this.startActivity(newsFeedIntent);
                break;

        }
    }
}
