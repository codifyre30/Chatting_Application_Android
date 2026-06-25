package com.codifyre.chattingapp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.codifyre.chattingapp.LoginActivity;
import com.codifyre.chattingapp.R;

public class SplashActivity extends AppCompatActivity {

    //Classname objectname;
    LinearLayout llMain;
    ImageView ivMainLogo;
    TextView tvMainTitle, tvMainSlogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);



        Handler handler = new Handler();
        handler .postDelayed(new Runnable() {
            @Override
            public void run() {
                // Classname objectname = new Cinstructorname(FirstActivity.this, SecondActivity.class);
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}