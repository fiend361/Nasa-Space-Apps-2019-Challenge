package com.jsoftware.nasa;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    ProgressBar mProgress;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        mProgress = findViewById(R.id.progressBar);

        mWebView = findViewById(R.id.mWebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.setWebViewClient(new WebViewClient()
                                  {
                                      @Override
                                      public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                          super.onPageStarted(view, url, favicon);

                                          mWebView.setVisibility(View.GONE);
                                          mProgress.setVisibility(View.VISIBLE);
                                          if (url.equals("https://www.google.com/")){
                                              Toast.makeText(PaymentActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
                                          } else if (url.equals("https://www.google.com/done")){
                                              Toast.makeText(PaymentActivity.this, "Done", Toast.LENGTH_SHORT).show();
                                          }
                                      }

                                      @Override
                                      public void onPageFinished(WebView view, String url) {
                                          super.onPageFinished(view, url);

                                          mWebView.setVisibility(View.VISIBLE);
                                          mProgress.setVisibility(View.GONE);

                                      }
                                  }
        );
        mWebView.loadUrl("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=VC5PX9WA2W5ZY");
    }
}
