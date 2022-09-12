package com.example.ganna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainQuestion extends AppCompatActivity {
    EditText etQustion;
    Button btnSend;
    EditText etNameQ, etPhoneQ;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_question);
        btnSend = findViewById(R.id.btnSend);
        etNameQ = findViewById(R.id.etNamqQ);
        etPhoneQ = findViewById(R.id.etPhoneQ);
        etQustion = findViewById(R.id.etQueistion);
        webView = findViewById(R.id.webview2);
    }

    public void send(View view) {
        validate();


    }
    private Boolean validate() {
        String name = etNameQ.getText().toString();
        String number = etPhoneQ.getText().toString();
        String question = etQustion.getText().toString();

        if (name.length() < 12) {
            etNameQ.requestFocus();
            etNameQ.setError("At least 12 Character");
            return false;
        } else if (number.length() < 11|| number.length() >= 12) {
            etPhoneQ.requestFocus();
            etPhoneQ.setError("Put Number with 11 digits");
            return false;
        } else if (question.length() ==0) {
            etQustion.requestFocus();
            etQustion.setError("Please Type Your Message");
            return false;
        } else {
            webView.loadUrl("http://51.210.20.68/Ganna/ms.php?FullName="+etNameQ.getText()+"&PhoneNo="+etPhoneQ.getText()+"&message="+etQustion.getText());

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    etNameQ.getText().clear();
                    etPhoneQ.getText().clear();
                    etQustion.getText().clear();
                }
            }, 5000);
            Toast.makeText(MainQuestion.this, "Sent", Toast.LENGTH_LONG).show();
            Intent in = new Intent(MainQuestion.this,MainActivity.class);
            startActivity(in);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            return true;
        }
    }
}