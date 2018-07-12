package com.example.a1406044.myapplication;

/**
 * Created by 1406044 on 09-04-2017.
 */

public class NewsData {
    public String mAurther;
    public String mTitle;
    public String mDescription;
    public String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAurther() {
        return mAurther;
    }

    public void setAurther(String mAurther) {
        this.mAurther = mAurther;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
