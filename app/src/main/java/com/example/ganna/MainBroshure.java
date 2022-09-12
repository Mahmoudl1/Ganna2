package com.example.ganna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainBroshure extends AppCompatActivity {
ImageView imageView,imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broshure);
       // getWindow().setBackgroundDrawableResource(R.drawable.apphome);
        imageView = findViewById(R.id.imageView);
        imageView1 =findViewById(R.id.imageView2);
        Glide.with(this).load("http://51.210.20.68/Ganna/1.jpg").into(imageView);
        Glide.with(this).load("http://51.210.20.68/Ganna/2.jpg").into(imageView1);

    }
    public void locaton(View view) {

        gotoUrl("https://www.google.com/maps/place/The+National+Museum+of+Egyptian+Civilization./@30.0081493,31.2460717,17z/data=!3m1!4b1!4m5!3m4!1s0x1458476863e39e8f:0xc2e058446f8f145d!8m2!3d30.0081493!4d31.2482604");
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void pdf(View view) {
        gotoUrl(
                "http://51.210.20.68/Ganna/flyer.pdf");
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}