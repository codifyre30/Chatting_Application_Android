package com.codifyre.chattingapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    ImageView ivLoginLogo;
    EditText etLoginUsername, etLoginPassword;
    CheckBox cbLoginShowHidePassword;
    Button btnLoginButton;
    TextView tvLoginNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ivLoginLogo = findViewById(R.id.ivLoginLogo);
        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        cbLoginShowHidePassword = findViewById(R.id.cbloginShowHidePassword);
        btnLoginButton = findViewById(R.id.btnloginbutton);
        tvLoginNewUser = findViewById(R.id.tvLoginNewUser);

        cbLoginShowHidePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    etLoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    etLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLoginUsername.getText().toString().isEmpty()) {
                    etLoginUsername.setError("Please Enter Your Username");
                } else if(etLoginUsername.getText().toString().length() < 8){
                    etLoginUsername.setError("Username length should be minimum 8 charecters");
                } else if (etLoginPassword.getText().toString().isEmpty()) {
                    etLoginPassword.setError("Please Enter Your Password");
                } else if (etLoginPassword.getText().toString().length() < 8) {
                    etLoginPassword.setError("Password length should be minimum 8 charecters");
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login SuccessFul", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }


        });

        tvLoginNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        }
    }
