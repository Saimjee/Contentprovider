package com.example.sunlight1.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        ContentResolver resolver = getContentResolver();
        Uri uri = ContentHelper.insertContent(resolver);
        Log.d(TAG, "Uri:"+uri.getPath());
        String data = ContentHelper.fetchContent(resolver, uri);
        TextView view = (TextView)findViewById(R.id.data);
        view.setText(data);

        int rows = ContentHelper.updateContent(resolver, uri);
        Log.d(TAG, "Rows Updated:"+ rows);
        data = ContentHelper.fetchContent(resolver, uri);
        TextView updateView = (TextView)findViewById(R.id.updatedata);
        updateView.setText(data);

        rows = ContentHelper.deleteContent(resolver);
        Log.d(TAG, "Rows Deleted:"+ rows);
    }
}

