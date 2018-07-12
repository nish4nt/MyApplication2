package com.example.a1406044.myapplication.ViewPagerTransForm;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 1406044 on 07-04-2017.
 */

class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    public static final float MIN_SCALE = 0.85f;
    public static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        int pagewidth = page.getWidth();
        int pageHeight = page.getHeight();

        if (position < -1){
            page.setAlpha(0);
        }
        else if (position <=1){
            float scaleFactor = Math.max(MIN_SCALE,1-Math.abs(position));
            float vertMarg = pageHeight * (1-scaleFactor) / 2;
            float horMarg = pagewidth * (1-scaleFactor) / 2;
            if (position <0){
                page.setTranslationX(horMarg - vertMarg / 2);
            }else{
                page.setTranslationX(-horMarg+vertMarg / 2);
            }

            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)/
                    (1-MIN_SCALE) * (1-MIN_ALPHA));
        }
        else {
            page.setAlpha(0);
        }
    }
}
