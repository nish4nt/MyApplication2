package com.example.a1406044.myapplication.Adepter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a1406044.myapplication.NewsData;
import com.example.a1406044.myapplication.R;

import java.util.List;

/**
 * Created by 1406044 on 07-04-2017.
 */

public class NewsPagerAdapter extends PagerAdapter {


    public static final String TAG = NewsPagerAdapter.class.getSimpleName();
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private NewsData news;
    private List<NewsData> list;
   // private int nPage;
    private TextView newsAurthor, discription, title;
    private ImageView newsImage;
    private CardView cardViewLayout;
    private int count=0;
    private Toolbar toolbar;

    public NewsPagerAdapter(Context context, List<NewsData> list) {
        mContext = context;
        this.list = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if (list == null) return 0;
        return list.size();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        View v = mLayoutInflater.inflate(R.layout.pager_item, null, false);
        newsAurthor = (TextView) v.findViewById(R.id.newsAurthor);
        discription = (TextView) v.findViewById(R.id.discription);
        newsImage = (ImageView) v.findViewById(R.id.newsImagePic);
        title = (TextView) v.findViewById(R.id.titleNews);
        cardViewLayout = (CardView) v.findViewById(R.id.layoutView);

        cardViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"inPager" + count,Toast.LENGTH_SHORT).show();
                count++;

            }
        });

        Glide.with(mContext).load(list.get(position).getImageUrl()).into(newsImage);
        newsAurthor.setText(list.get(position).getAurther());
        discription.setText(list.get(position).getDescription());
        title.setText(list.get(position).getTitle());
        container.addView(v);

        return v;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
