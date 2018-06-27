package com.example.gallo.scouthq1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class AccountActivity extends Activity {
    private ListView mList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        mList = (ListView) findViewById(R.id.list);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view_card:
                Intent myIntent = new Intent(AccountActivity.this, PlayerCard.class);
                AccountActivity.this.startActivity(myIntent);
                break;
            case R.id.btn_settings:
                Intent myIntent2 = new Intent(AccountActivity.this, PlayerCard.class);
                AccountActivity.this.startActivity(myIntent2);
                break;
            case R.id.btn_help:
                Intent myIntent3 = new Intent(AccountActivity.this, PlayerCard.class);
                AccountActivity.this.startActivity(myIntent3);
                break;
        }
    }
}