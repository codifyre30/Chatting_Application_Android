package com.codifyre.chattingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.codifyre.chattingapp.fragment.CallsFragment;
import com.codifyre.chattingapp.fragment.ChatsFragment;
import com.codifyre.chattingapp.fragment.CommunnitiesFragment;
import com.codifyre.chattingapp.fragment.UpdatesFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    boolean doubletap = false;

    Toolbar homeToolbar;
    private boolean doubletab;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferences = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        editor = preferences.edit();

        boolean firsttime = preferences.getBoolean("IsFirstTime", true);
        if (firsttime)
        {
            welcome();
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
          bottomNavigationView.setSelectedItemId(R.id.bottom_nav_chats);


        // Initialize Toolbar
        homeToolbar = findViewById(R.id.homeToolbar);


    }

    private void welcome() {
        AlertDialog.Builder ad = new AlertDialog.Builder(HomeActivity.this);
        ad.setTitle("Welcome!");
        ad.setMessage("Welcome to Codify \uD83C\uDF93\n" +
                "Stay Connected Work Smart.\n" +
                "Let’s get started!" );
        ad.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        }).create().show();
        editor.putBoolean("IsFirstTime", false).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_new_group) {
            Toast.makeText(this, "New group", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_starred_messages) {
            Toast.makeText(this, "Starred messages", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_selected_chat) {
            Toast.makeText(this, "Selected chat", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_mark_all_read) {
            Toast.makeText(this, "Mark all as read", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_new_community) {
            Toast.makeText(this, "New community", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_my_profile) {
            Toast.makeText(this, "My profile", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_logout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (doubletab)
        {
            finishAffinity();
        }
        else
        {
            Toast.makeText(HomeActivity.this, "Press Again to Exit App", Toast.LENGTH_SHORT).show();
            doubletap = true;
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletap = false;
                }
            },2000);
        }

    }


    ChatsFragment chatsFragment = new ChatsFragment();
    UpdatesFragment updatesFragment = new UpdatesFragment();
    CommunnitiesFragment communnitiesFragment = new CommunnitiesFragment();
    CallsFragment callsFragment = new CallsFragment();




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
        if (menuitem.getItemId() == R.id.bottom_nav_chats)
        {
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, chatsFragment).commit();
        }
        else if (menuitem.getItemId() == R.id.bottom_nav_updates)
        {
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, updatesFragment).commit();
        } else if (menuitem.getItemId() == R.id.bottom_nav_communities) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,communnitiesFragment).commit();
        } else if (menuitem.getItemId() == R.id.bottom_nav_calls) {
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, callsFragment).commit();
        }
        return false;
    }
}