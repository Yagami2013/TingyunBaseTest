package com.ytt.tingyunbasetest.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.smtt.sdk.WebChromeClient;


import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.ytt.tingyunbasetest.R;
import com.ytt.tingyunbasetest.util.Tingyun;
import com.ytt.tingyunbasetest.util.X5WebView;

public class X5Demo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5webview);

        EditText input=(EditText)findViewById(R.id.edit_url);
        Button requestButton=(Button)findViewById(R.id.btn_request_url);
        X5WebView webview=(X5WebView)findViewById(R.id.web);
        android.webkit.WebView web_native=(android.webkit.WebView)findViewById(R.id.web_native);
        Tingyun.addX5Bridge(webview);

        webview.setWebViewClient(new WebViewClient(){});
        web_native.setWebViewClient(new android.webkit.WebViewClient(){});

        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                Tingyun.embedX5Webview(webView,i);
            }
        });
        web_native.setWebChromeClient(new android.webkit.WebChromeClient(){
            @Override
            public void onProgressChanged(android.webkit.WebView webView, int i) {
                super.onProgressChanged(webView, i);
                Tingyun.embedWebview(webView,i);
            }
        });

        webview.setWebContentsDebuggingEnabled(true);

        String url="file:///android_asset/index.html";
        webview.loadUrl(url);
        web_native.loadUrl(url);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=input.getText().toString();
                webview.loadUrl(url);
                web_native.loadUrl(url);
            }
        });
    }

}
