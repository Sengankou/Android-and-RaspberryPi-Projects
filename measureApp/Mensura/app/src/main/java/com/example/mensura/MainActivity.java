package com.example.mensura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout fl;
        Button btn;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        CameraPreview cameraPreview = new CameraPreview(this);
        btn = new Button(this);
        btn.setText("BUTTON");

        fl = new FrameLayout(this);
        fl.addView(cameraPreview);
        fl.addView(btn,  new LinearLayout.LayoutParams(200, 100));
        setContentView(fl);
    }
}