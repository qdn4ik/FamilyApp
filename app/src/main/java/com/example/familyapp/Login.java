package com.example.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class Login extends AppCompatActivity {

    Button btn_login , btn_create_login , btn_forget;
    TextInputLayout et_phone_login , et_password_login;
    CountryCodePicker ccp_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findId();
        create_account();
    }

    private void findId(){
        ccp_login = findViewById(R.id.ccp_login);
        et_phone_login = findViewById(R.id.et_phone_login);
        et_password_login = findViewById(R.id.et_password_login);
        btn_create_login = findViewById(R.id.btn_create_login);
        btn_forget = findViewById(R.id.btn_forget);
        btn_login = findViewById(R.id.btn_login);
    }

    private void create_account(){
        btn_create_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,CreateAccount.class);
                startActivity(intent);
            }
        });
    }
}