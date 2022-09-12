package com.example.ganna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button btnBrochure,btnQuestion,btnRegister,btnVideo, btnOrganizers;
    ConstraintLayout constraintLayout ;
    ImageView shine ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBrochure = findViewById(R.id.btnBrochure);
        btnQuestion = findViewById(R.id.btnQuestion);
        btnRegister = findViewById(R.id.btnRegister);
        btnVideo = findViewById(R.id.btnVideo);
        btnOrganizers = findViewById(R.id.btnOrganizes);
        constraintLayout = findViewById(R.id.conC);
        shine = findViewById(R.id.shine);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setShine();
                    }
                });

            }
        },3,3, TimeUnit.SECONDS);

    }

    public void register(View view) {
        Intent in = new Intent(MainActivity.this,MainRegister.class);
        startActivity(in);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void broshure(View view) {
        Intent in = new Intent(MainActivity.this,MainBroshure.class);
        startActivity(in);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void ofvideo(View view) {

        gotoUrl("https://Tinyurl.com/gannav");
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void urques(View view) {
        Intent in = new Intent(MainActivity.this,MainQuestion.class);
        startActivity(in);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void org(View view) {
        Intent in = new Intent(MainActivity.this,MainOrganizers.class);
        startActivity(in);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    private void setShine(){
        Animation animation =new TranslateAnimation(
                0,constraintLayout.getWidth()+shine.getWidth(),0,0
        );
        animation.setDuration(750);
        animation.setFillAfter(true);
        animation.setInterpolator(new AccelerateInterpolator());
        shine.startAnimation(animation);
    }
}