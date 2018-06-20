package com.example.gallo.scouthq1;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.gallo.scouthq1.R.id.selection_button;
import static com.example.gallo.scouthq1.R.id.account_button;
//import com.shirwa.simplistic_rss.RssItem;
//import com.shirwa.simplistic_rss.RssReader;


public class NewsFeed extends Activity implements View.OnClickListener{
    private ListView mList;
    ArrayAdapter<String> adapter;
    OnSwipeTouchListener onSwipeTouchListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        mList = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, R.layout.basic_list_item);
        Intent sportSelection = getIntent();
        new GetRssFeed().execute(sportSelection.getStringExtra("urlString"));

        findViewById(selection_button).setOnClickListener(this);
        findViewById(account_button).setOnClickListener(this);

        onSwipeTouchListener = new OnSwipeTouchListener() {
            public boolean onSwipeRight() {
                Intent myIntent = new Intent(NewsFeed.this, SportsSelection.class);
                NewsFeed.this.startActivity(myIntent);
                return true;

            }

            public boolean onSwipeLeft() {
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
                FeedReader rssReader = new FeedReader(params[0]);
                for (FeedSource item : rssReader.getItems())
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
        switch (view.getId()) {
            case R.id.selection_button:
                Intent myIntent = new Intent(NewsFeed.this, SportsSelection.class);
                NewsFeed.this.startActivity(myIntent);
                break;
            case R.id.account_button:
                Intent myIntent2 = new Intent(NewsFeed.this, AccountActivity.class);
                NewsFeed.this.startActivity(myIntent2);
                break;
        }
    }
}