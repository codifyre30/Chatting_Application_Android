package com.codifyre.chattingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.bottom_nav_communities)
        {
            Toast.makeText(HomeActivity.this, "Chats Fragment Click", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.bottom_nav_updates) {
            Toast.makeText(HomeActivity.this, "Updates Fragment Click", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.bottom_nav_communities) {
            Toast.makeText(HomeActivity.this, "Communities Fragment Click", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.bottom_nav_calls) {
            Toast.makeText(HomeActivity.this, "Calls Fragment Click", Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}