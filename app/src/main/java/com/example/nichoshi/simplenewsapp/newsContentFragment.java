package com.example.nichoshi.simplenewsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by NichoShi on 2017/3/8.
 */

public class newsContentFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_fragment,container,false);
        return view;
    }

    public void refresh(String title,String content){
        View linearLayout = view.findViewById(R.id.contentFragmentLayout);
        linearLayout.setVisibility(View.VISIBLE);
        TextView Title = (TextView)view.findViewById(R.id.contentTitle_TextView);
        TextView Content = (TextView) view.findViewById(R.id.content_textView);
        Title.setText(title);
        Content.setText(content);
    }
}
