package com.example.a1406044.myapplication.Activitys;

import android.support.v4.view.PagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.a1406044.myapplication.DataCallback;
import com.example.a1406044.myapplication.ViewPagerTransForm.DepthPageTransformer;
import com.example.a1406044.myapplication.Networking;
import com.example.a1406044.myapplication.News;
import com.example.a1406044.myapplication.NewsData;
import com.example.a1406044.myapplication.Adepter.NewsPagerAdapter;
import com.example.a1406044.myapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private News news;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String data = getIntent().getExtras().getString("source");
        Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_SHORT).show();

        viewPager = (ViewPager) findViewById(R.id.pager);
        Networking network = new Networking(this,data);
        network.createData(new DataCallback() {
            @Override
            public void onDataReceived(final List<NewsData> list) {
                if (list != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pagerAdapter = new NewsPagerAdapter(MainActivity.this, list);
                            viewPager.setAdapter(pagerAdapter);
                            viewPager.setPageTransformer(true, new DepthPageTransformer());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

}
