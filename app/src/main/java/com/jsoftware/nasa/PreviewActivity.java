package com.jsoftware.nasa;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity {

    private WebView mWebView;
    Button btn;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        btn = findViewById(R.id.btn3);

        mWebView = findViewById(R.id.mWebView2);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://solarsystem.nasa.gov/planets/dwarf-planets/pluto/overview");

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://google.com");

            }
        });

    }

}


