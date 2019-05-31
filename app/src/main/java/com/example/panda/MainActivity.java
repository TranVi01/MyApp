package com.example.panda;

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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = Home.newHome();
                    actionBar.setTitle("Shop");
                    LoadFrafment(selectedFragment);
                    return true;
                case R.id.navigation_gift:

                    selectedFragment = Gift.newGift();
                    actionBar.setTitle("Gift");
                    LoadFrafment(selectedFragment);
                    return true;
                case R.id.navigation_maps:

                    selectedFragment = Map.newmap();
                    actionBar.setTitle("Maps");
                    LoadFrafment(selectedFragment);
                    return true;
                case R.id.navigation_accout:

                    selectedFragment = Accout.newInstance();
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
