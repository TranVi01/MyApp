package com.example.panda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.panda.Models.SelelectAccout;


public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new Home();
                    actionBar.setTitle("Shop");
                    LoadFrafment(selectedFragment);
                    return true;
                case R.id.navigation_qr:
                    selectedFragment = new QR();
                    actionBar.setTitle("Code Qr");
                    LoadFrafment(selectedFragment);
                    return true;
                case R.id.navigation_maps:

                    selectedFragment = new Map();
                    actionBar.setTitle("Maps");
                    LoadFrafment(selectedFragment);
                    return true;
                case R.id.navigation_accout:
                    selectedFragment = new Accout();
                    actionBar.setTitle("Accout");
                    LoadFrafment(selectedFragment);
                    return true;
            }

            return false;
        }
    };

    private void LoadFrafment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        actionBar.setTitle("Shop");
        LoadFrafment(new Home());
    }


}
