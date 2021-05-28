package com.jsoftware.nasa;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class UserInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(mListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WatchFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.watch:
                    selectedFragment = new WatchFragment();
                    break;

                case R.id.dashboard:
                    selectedFragment = new DashboardFragment();
                    break;

                case R.id.guide:
                    selectedFragment = new TourGuideFragment();
                    break;

                case R.id.faq:
                    selectedFragment = new FaqFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };
}
