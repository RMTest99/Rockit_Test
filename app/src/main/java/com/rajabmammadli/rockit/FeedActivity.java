package com.rajabmammadli.rockit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rajabmammadli.rockit.Fragments.HomeFragment;
import com.rajabmammadli.rockit.Fragments.CartFragment;
import com.rajabmammadli.rockit.Fragments.ProfileFragment;
import com.rajabmammadli.rockit.Fragments.SearchFragment;
import com.rajabmammadli.rockit.Fragments.TrendFragment;

public class FeedActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private TrendFragment trendFragment;
    private CartFragment cartFragment;
    private ProfileFragment profileFragment;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mMainNav = findViewById(R.id.main_nav);
        mMainFrame = findViewById(R.id.main_frame);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        trendFragment = new TrendFragment();
        cartFragment = new CartFragment();
        profileFragment = new ProfileFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home :
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_search :
                        setFragment(searchFragment);
                        return true;

                    case R.id.nav_trend :
                        setFragment(trendFragment);
                        return true;

                    case R.id.nav_cart :
                        setFragment(cartFragment);
                        return true;

                    case R.id.nav_profile :
                        setFragment(profileFragment);
                        return true;

                    default:
                        return false;


                }

            }
        });
    }

    //Logout user
    public void logoutClicked(View view) {
        firebaseAuth.signOut();

        Toast.makeText(FeedActivity.this, "User logged out", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(FeedActivity.this, AuthenticationActivity.class);
        startActivity(intent);
        finish();
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}