package com.example.a1406044.myapplication;

/**
 * Created by 1406044 on 09-04-2017.
 */

public class News extends NewsData {
    public NewsData[] getNewsDatas() {
        return newsDatas;
    }

    public void setNewsDatas(NewsData[] newsDatas) {
        this.newsDatas = newsDatas;
    }

    private NewsData[] newsDatas;
}
