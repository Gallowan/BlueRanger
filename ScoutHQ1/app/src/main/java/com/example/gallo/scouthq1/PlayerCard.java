package com.example.gallo.scouthq1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class PlayerCard extends Activity {
    private ListView mList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_card);
        mList = (ListView) findViewById(R.id.list);
    }
}