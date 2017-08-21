package sg.edu.rp.c346.rpwebsite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView wvPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wvPage = (WebView)findViewById(R.id.webViewPage);
        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("url");


        wvPage.setWebViewClient(new WebViewClient());

        WebSettings webSettings = wvPage.getSettings();
        webSettings.setJavaScriptEnabled(true);

        wvPage.loadUrl(url);


    }
}
