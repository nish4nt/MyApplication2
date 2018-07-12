package com.example.a1406044.myapplication.ViewPagerTransForm;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 1406044 on 07-04-2017.
 */

public class VerticalViewPager extends ViewPager {
    private static final int V = 0;
    private static final int H = 1;

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOverScrollMode(OVER_SCROLL_NEVER);
        setPageTransformer(true, new VerticalPagerTransform());
    }

    public class VerticalPagerTransform implements ViewPager.PageTransformer {

        private static final float MIN_SCALE = 0.75f;

        @Override
        public void transformPage(View page, float position) {
            if (position < -1) {
                page.setAlpha(0);

            } else if (position <= 0) {
                page.setAlpha(1);

                page.setTranslationX(page.getWidth() * -position);

                float yPositon = position * page.getHeight();
                page.setTranslationY(yPositon);
                page.setScaleX(1);
                page.setScaleY(1);
            } else if (position <= 1) {
                page.setAlpha(1);

                page.setTranslationX(page.getWidth() * -position);

                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
            } else {
                page.setAlpha(0);
            }
        }
    }

    public MotionEvent swapXY(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();

        float newX = (event.getY() / height) * width;
        float newY = (event.getX() / width) * height;

        event.setLocation(newX, newY);
        return event;
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = super.onInterceptHoverEvent(swapXY(event));
        //swapXY(event);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }
}
