package com.example.ganna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainRegister extends AppCompatActivity {
    EditText etName, etEmail, etPhone, etPlace, etInterest;
    Button btnSub;
    WebView webView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPlace = findViewById(R.id.etPlace);

        etInterest = findViewById(R.id.etInterest);
        btnSub = findViewById(R.id.btnSubmit);
        webView = findViewById(R.id.webview1);
    }

    public void sub(View view) {
        validateAcc();

    }
    private Boolean validateAcc() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String number = etPhone.getText().toString();
        String place = etPlace.getText().toString();
        String field = etInterest.getText().toString();


        if (name.length() < 12) {
            etName.requestFocus();
            etName.setError("At least 12 Character");
            return false;
        } else if (email.length() == 0) {
            etEmail.requestFocus();
            etEmail.setError("Empty Email");
            return false;
//        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            etEmail.requestFocus();
//            etEmail.setError("Invalid Email");
//            return false;
        } else if (number.length() < 11|| number.length() >= 12 ) {
            etPhone.requestFocus();
            etPhone.setError("Put Number with 11 digits");
            return false;
//        }else if (Patterns.PHONE.matcher(number).matches()){
//            etPhen.requestFocus();
//            etPhen.setError("Invalid Number");
//            return false;
        } else if (place.length() == 0) {
            etPlace.requestFocus();
            etPlace.setError("Empty Place");
            return false;
        }

         else if (field.length() ==0) {
            etInterest.requestFocus();
            etInterest.setError("Empty Field");
            return false;
        } else {
            webView.loadUrl("http://51.210.20.68/Ganna/reg.php?FullName="+etName.getText()+"&PhoneNo="+ etPhone.getText()+"&Email="+etEmail.getText()+"&WorkPlace="+etPlace.getText()+"&Degree=xyz&grad=avc&interest="+etInterest.getText());
            webView.setVisibility(View.VISIBLE);
            Toast.makeText(MainRegister.this, "Registered Successfully", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    etName.getText().clear();
                    etEmail.getText().clear();

                    etInterest.getText().clear();

                    etPlace.getText().clear();
                    etPhone.getText().clear();
                }
            }, 5000);
            return true;
        }


    }
}