package com.example.sachin.arohan;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by sachin on 20/12/15.
 */
public class ourClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView v,String url){
        v.loadUrl(url);
        return true;
    }
}
