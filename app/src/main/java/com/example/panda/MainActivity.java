package com.example.panda;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private String name;
    private String email;
    private int phone;


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
                case R.id.navigation_gift:
                    selectedFragment = new Gift();
                    actionBar.setTitle("Gift");
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
                    InformationAccout informationAccout = new InformationAccout();
                    name = informationAccout.getName();
                    email = informationAccout.getEmail();
                    phone = informationAccout.getPhone();
                    selectedFragment = Accout.newInstance(name, email, phone);
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
