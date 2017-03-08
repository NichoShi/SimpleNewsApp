package com.example.nichoshi.simplenewsapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class newsContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content_layout);
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        FragmentManager fragmentManager = getFragmentManager();
        newsContentFragment contentFragment = (newsContentFragment) fragmentManager.findFragmentById(R.id.newsContentLayoutFragment);
        contentFragment.refresh(title,content);
    }
}
