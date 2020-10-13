package com.example.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyOTP extends AppCompatActivity {

    PinView et_verify;
    TextView txt_verify , txt_error_verify;
    Button btn_verify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);
        findId();
    }

    private void findId(){
        et_verify = findViewById(R.id.et_verify);
        txt_verify = findViewById(R.id.txt_verify);
        txt_error_verify = findViewById(R.id.txt_error_verify);
        btn_verify = findViewById(R.id.btn_verify);
    }

}