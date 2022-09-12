package com.example.ganna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainOrganizers extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_organizers);
    }

    public void call(View view) {

//        dialPhoneNumber("01015118974");
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "01000000000"));
//        startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01015118974"));

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(MainOrganizers.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainOrganizers.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            }
            else
            {
                startActivity(intent);
            }
        }
        else
        {
            startActivity(intent);
        }
    }

    public void email(View view) {

//        gotoUrl("Mailto:alpha.centauri@consultant.com");
//         Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:alpha.centauri@consultant.com")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL,true);
//
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"alpha.centauri@consultant.com"});


        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainOrganizers.this, "There are no email clients installed.",Toast.LENGTH_SHORT).show();
        }
    }

    public void wp(View view) {
        gotoUrl(
                "https://api.whatsapp.com/send/?phone=201114610940&text&app_absent=0");
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
//    public void dialPhoneNumber(String phoneNumber) {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:" + phoneNumber));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }

}