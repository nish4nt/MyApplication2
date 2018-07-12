package com.example.a1406044.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.example.a1406044.myapplication.Adepter.NewsPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by 1406044 on 09-04-2017.
 */

public class Networking {

    Context mContext;
    String sourceUrl = null;
    public Networking(Context context,String source) {
        mContext = context;
        sourceUrl = source;
        Toast.makeText(mContext,"in Network"+sourceUrl, LENGTH_SHORT).show();
    }

    public static final String TAG = NewsPagerAdapter.class.getSimpleName();
    int nPage;

    List<NewsData> list = new ArrayList<>();
    public void createData(final DataCallback callback) {
        String API_KEY = "1d2acff69ff145eb9cb2ef15fee27551";
        String URL = "https://newsapi.org/v1/articles?source="+sourceUrl+"&sortBy=top&apiKey="
                + API_KEY;
        if (isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(URL).build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsoneData = response.body().string();
                        Log.v(TAG, jsoneData);
                        if (response.isSuccessful()) {
                            list = getCurrentDetails(jsoneData);
                            callback.onDataReceived(list);
                        } else {
                            aleartUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception Caught:", e);
                    } catch (JSONException e) {
                        Log.e(TAG, "Exception Caught:", e);
                    }
                }
            });
        } else {
            Toast.makeText(mContext, "Network is not working", LENGTH_SHORT).show();
        }
    }

    public List<NewsData> getCurrentDetails(String jsoneData) throws JSONException {
        JSONObject newsJsone = new JSONObject(jsoneData);
        String status = newsJsone.getString("status");
        Log.v(TAG, "From jason:" + status);
        JSONArray data = newsJsone.getJSONArray("articles");
        nPage = data.length();
        List<NewsData> u = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            JSONObject singleNews = data.getJSONObject(i);
            NewsData newsData = new NewsData();
            newsData.setAurther(singleNews.getString("author"));
            newsData.setTitle(singleNews.getString("title"));
            newsData.setDescription(singleNews.getString("description"));
            newsData.setImageUrl(singleNews.getString("urlToImage"));
            u.add(newsData);
        }
        return u;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manager.getActiveNetworkInfo();
        boolean isPresent = false;
        if (network != null && network.isConnected()) {
            isPresent = true;
        }
        return isPresent;
    }

    private void aleartUserAboutError() {
        AleartDialogFragment alert = new AleartDialogFragment();
        alert.show(alert.getFragmentManager(), "erroe_dialog");
    }
}