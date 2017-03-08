package com.example.nichoshi.simplenewsapp;

/**
 * Created by NichoShi on 2017/3/7.
 */

public class News {
    private String title;
    private String content;
    public News(String title,String content){
        setTitle(title);
        setContent(content);
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }
}
