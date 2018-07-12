package com.example.a1406044.myapplication.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a1406044.myapplication.R;

public class ChoiceActivity extends AppCompatActivity {

    TextView articles ,mTech,cricketNews,theHindu;
    public String newsRrc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        articles = (TextView)findViewById(R.id.articlesView);
        mTech = (TextView)findViewById(R.id.newsView);
        cricketNews = (TextView) findViewById(R.id.cricketNews);
        theHindu = (TextView) findViewById(R.id.theHinduNews);

        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this,MainActivity.class);
                intent.putExtra("source","cnn");
                startActivity(intent);
            }
        });

        mTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this,MainActivity.class);
                intent.putExtra("source","bbc-sport");
                startActivity(intent);
            }
        });
        cricketNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this,MainActivity.class);
                intent.putExtra("source","espn-cric-info");
                startActivity(intent);
            }
        });

        theHindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this,MainActivity.class);
                intent.putExtra("source","the-hindu");
                startActivity(intent);
            }
        });
    }
}
