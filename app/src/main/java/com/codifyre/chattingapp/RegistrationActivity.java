package com.codifyre.chattingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    EditText etName, etMobileNo, etEmailId, etUsername, etPassword;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.etRegisterName);
        etMobileNo = findViewById(R.id.etRegisterMobileNumber);
        etEmailId = findViewById(R.id.etRegisterEmailId);
        etUsername = findViewById(R.id.etRegisterUsername);
        etPassword = findViewById(R.id.etRegisterPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty()) {
                    etName.setError("Please Enter Your Name");
                } else if (etMobileNo.getText().toString().isEmpty()) {
                    etMobileNo.setError("Please Enter Your Mobile Number");
                } else if (etMobileNo.getText().toString().length() != 10) {
                    etMobileNo.setError("Invalid Mobile Number");
                } else if (etEmailId.getText().toString().isEmpty()) {
                    etEmailId.setError("Please Enter Your Email ID");
                } else if (etEmailId.getText().toString().contains("@") ||
                        !etEmailId.getText().toString().contains(".com")) {
                    etEmailId.setError("Please Enter Valid Email ID");
                } else if (etUsername.getText().toString().isEmpty()) {
                    etUsername.setError("Please Enter Your Username");
                } else if (etUsername.getText().toString().length() < 8) {
                    etUsername.setError("Username must be greater than 8 characters");
                } else if (etUsername.getText().toString().matches(".*[A-Z].*")) {
                    etUsername.setError("Please Enter Atleast 1 Uppercase Letter in Username");
                } else if (etUsername.getText().toString().matches(".*[a-z].*")) {
                    etUsername.setError("Please Enter Atleast 1 Lowercase Letter in Username");
                } else if (!etUsername.getText().toString().matches(".*[0-9].*")) {
                    etUsername.setError("Please Enter Atleast 1 Digit in Username");
                } else if (etPassword.getText().toString().isEmpty()) {
                    etPassword.setError("Please Enter Your Password");
                } else if (etPassword.getText().toString().length() < 8) {
                    etPassword.setError("Password must be greater than 8 ");
                } else {
                    Toast.makeText(RegistrationActivity.this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}