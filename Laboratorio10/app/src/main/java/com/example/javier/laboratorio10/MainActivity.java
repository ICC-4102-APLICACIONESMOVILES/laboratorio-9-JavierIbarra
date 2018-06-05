package com.example.javier.laboratorio10;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    String url = "http://almaaustralis.cl/";//"http://demo.tutorialzine.com/2012/04/mobile-touch-gallery/";
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        web = (WebView) findViewById(R.id.id_webview);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        web.loadUrl(url);
        WebInterface webInterface = new WebInterface(this);
        web.addJavascriptInterface(webInterface,"android");
        webInterface.consoleMessage("Mens");

        web.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView webView,String url){
                return false;

            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.d("Lab","goBack");
        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
