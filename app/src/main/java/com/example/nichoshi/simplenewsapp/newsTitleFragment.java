package com.example.nichoshi.simplenewsapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NichoShi on 2017/3/7.
 */

public class newsTitleFragment extends Fragment {
    private ListView titleList;
    private newsTitleAdapter titleAdapter;
    private boolean isLand;
    private List<News> newsList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_fragment,container,false);
        initNews();
        titleAdapter = new newsTitleAdapter(getActivity(),R.layout.title_list_item,newsList);
        titleList = (ListView) view.findViewById(R.id.newsTitleList);
        titleList.setAdapter(titleAdapter);
        titleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = newsList.get(position);
                if(isLand){

                    FragmentManager fragmentManager = getFragmentManager();
                    newsContentFragment contentFragment= (newsContentFragment) fragmentManager.findFragmentById(R.id.newsContentFragment);
                    contentFragment.refresh(news.getTitle(),news.getContent());

                }
                if(!isLand){
                    Intent intent = new Intent(getActivity(),newsContentActivity.class);
                    intent.putExtra("title",news.getTitle());
                    intent.putExtra("content",news.getContent());
                    getActivity().startActivity(intent);



                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLand = getActivity().findViewById(R.id.contentFrameLayout) != null;
    }

    public void initNews(){
        News news1 = new News("Succeed in College as a Learning Disabled Student","College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-than-stellar dining hall food. Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
        News news2 = new News("Google Android exec poached by China's Xiaomi","China's Xiaomi has poached a key Google executive involved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
        newsList.add(news1);
        newsList.add(news2);
    }





}
