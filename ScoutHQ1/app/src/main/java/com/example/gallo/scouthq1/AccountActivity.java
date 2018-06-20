package com.example.gallo.scouthq1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class AccountActivity extends Activity {
    private ListView mList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        mList = (ListView) findViewById(R.id.list);
    }
}