package com.example.familyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.familyapp.Helpers.UserHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class CreateAccount extends AppCompatActivity {

    TextInputLayout et_phone_register, et_user_register, et_password_register, et_confirm_password_register;
    Button btn_register;
    CountryCodePicker ccp_register;
    TextView txt_register, txt_error_register;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        findId();
        create_account();
    }

    private void findId() {
        et_user_register = findViewById(R.id.et_user_register);
        et_phone_register = findViewById(R.id.et_phone_register);
        et_password_register = findViewById(R.id.et_password_register);
        et_confirm_password_register = findViewById(R.id.et_confirm_password_register);
        btn_register = findViewById(R.id.btn_register);
        ccp_register = findViewById(R.id.ccp_register);
        txt_register = findViewById(R.id.txt_register);
        txt_error_register = findViewById(R.id.txt_error_register);
    }

    private void create_account() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database();
                Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void database() {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        String number = et_phone_register.getEditText().getText().toString();
        String ccp = ccp_register.getSelectedCountryCode();

        String name = et_user_register.getEditText().getText().toString();
        String password = et_password_register.getEditText().getText().toString();
        String phone = "+" + ccp + number;


        UserHelperClass helperClass = new UserHelperClass(name, phone, password);
        reference.child(phone).setValue(helperClass);
    }
}