package com.example.sachin.arohan;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab1 extends Fragment {
    WebView ourBrow;
    Button back,forward;
    SharedPreferences prefs;
    @Nullable ImageView bmImage;
    String MY_URL_STRING="http://10.42.0.1:80/android_connect/images/colossus.png";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        RelativeLayout v =(RelativeLayout)inflater.inflate(R.layout.tab_1, container, false);

        bmImage = (ImageView) v.findViewById(R.id.imageView);

      //  bmImage.setImageResource(R.drawable.aarohan);
       /*ourBrow= (WebView) v.findViewById(R.id.webView);

        back=(Button) v.findViewById(R.id.back_button);
        forward=(Button) v.findViewById(R.id.fwd_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ourBrow.canGoBack())
                    ourBrow.goBack();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ourBrow.canGoForward())
                    ourBrow.goForward();
            }
        });

        ourBrow.getSettings().setJavaScriptEnabled(true);
        ourBrow.getSettings().setLoadWithOverviewMode(true);
        ourBrow.getSettings().setUseWideViewPort(true);

        ourBrow.setWebViewClient(new ourClient());
        try {
            ourBrow.loadUrl("http://10.42.0.85/android_connect/images/colossus.png");
        }catch(Exception e){
            e.printStackTrace();
        }
  */
        new DownloadImageTask().execute();



        /*
        TextView text=(TextView)v.findViewById(R.id.textView2);
        prefs = this.getActivity().getSharedPreferences(MainActivityActivity.file,0);
        String data="Welcome, ";
        data = data.concat(prefs.getString("user name","New User"));
        text.setText(data);
        */
        return v;

    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... urls) {
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(MY_URL_STRING).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}

