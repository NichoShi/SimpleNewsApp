package com.example.nichoshi.simplenewsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * Created by NichoShi on 2017/3/7.
 */

public class newsTitleAdapter extends ArrayAdapter<News> {
    private int resourceId;
    public newsTitleAdapter(Context context, int ResourceId, List<News> objects){
        super(context,ResourceId,objects);
        resourceId = ResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        News news = getItem(position);
        if(convertView != null){
            view = convertView;
        }
        else{
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }
        TextView title = (TextView) view.findViewById(R.id.itemTitle);
        title.setText(news.getTitle());
        return view;
    }
}
