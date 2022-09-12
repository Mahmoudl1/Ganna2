package com.example.ganna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    MediaPlayer player ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        player = MediaPlayer.create(SplashScreen.this,R.raw.intro);
        player.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);

            }
        },6200);
    }
    @Override
    protected void onPause() {
        super.onPause();
        player.release();
        finish();
    }
}