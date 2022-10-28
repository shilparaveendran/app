package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.window.SplashScreen;

public class splashscreen extends AppCompatActivity {
      Handler handler;
      Runnable runnable;
      ImageView img;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        img=findViewById(R.id.imageView);
        img.animate().alpha(4000).setDuration(0);
        handler = new Handler();
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent intent =new Intent(splashscreen.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }

}