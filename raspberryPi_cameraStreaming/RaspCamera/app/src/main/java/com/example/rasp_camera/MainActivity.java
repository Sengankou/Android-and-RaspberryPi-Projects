package com.example.rasp_camera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    private Button reloadButton;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reloadButton = new Button(this);
        reloadButton = (Button) findViewById(R.id.button_reload);
        reloadButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                webView.reload();
                Log.d("Log:", "WebView is reloaded.");
            }
        });


        webView = new WebView(this);
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://192.168.11.18:5000/stream");
    }

}