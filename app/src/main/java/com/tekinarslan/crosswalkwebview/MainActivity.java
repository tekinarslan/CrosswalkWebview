package com.tekinarslan.crosswalkwebview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.xwalk.core.XWalkView;


public class MainActivity extends Activity {

    private XWalkView xWalkWebView;
    private EditText urlText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlText = (EditText) findViewById(R.id.url_bar);
        xWalkWebView = (XWalkView) findViewById(R.id.xwalkwebview);
        xWalkWebView.getSettings().setJavaScriptEnabled(true);
        xWalkWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        xWalkWebView.getSettings().setAllowContentAccess(true);
        xWalkWebView.getSettings().setAllowFileAccess(true);
        xWalkWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        xWalkWebView.getSettings().setLoadsImagesAutomatically(true);
        xWalkWebView.getSettings().setImagesEnabled(true);
        xWalkWebView.getSettings().setDomStorageEnabled(true);


        xWalkWebView.load("http://www.html5test.com",null);/*url must include http*/


        Button goButton = (Button) findViewById(R.id.go_button);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xWalkWebView.load(urlText.getText().toString(), null);
            }
        });
    }
}
