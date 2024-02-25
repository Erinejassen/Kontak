package com.example.kontak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ImageView kontaklogo,shine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kontaklogo = findViewById(R.id.kontaklogo);
        shine = findViewById(R.id.shine);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(new Runnable(){

            public void run(){
                runOnUiThread(new Runnable(){
                    public void run(){
                        shineStart();
                    }
                });
            }
        },3,3, TimeUnit.SECONDS);
    }

    private void shineStart(){

        Animation animation = new TranslateAnimation(
                0,kontaklogo.getWidth() + shine.getWidth(), 0, 0);
        animation.setDuration(550);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        shine.startAnimation(animation);
    }
}