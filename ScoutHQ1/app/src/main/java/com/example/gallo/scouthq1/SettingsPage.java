package com.example.gallo.scouthq1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by gallo on 7/4/2018.
 */

public class SettingsPage extends Activity {
    private ListView mList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mList = (ListView) findViewById(R.id.list);
    }
}
