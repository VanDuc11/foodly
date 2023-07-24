package com.example.foodly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;


import com.example.foodly.ViewAdapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mNavigationView;
    public ViewPager2 mViewPage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationView = findViewById(R.id.bottom_nav);
        mViewPage2 = findViewById(R.id.viewpage2);

        setmViewPage2();

        // ẩn toolbar
        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        mViewPage2.setCurrentItem(0);
                        break;

                    case R.id.action_giohang:
                        mViewPage2.setCurrentItem(1);

                        break;
                    case R.id.action_thongbao:
                        mViewPage2.setCurrentItem(2);

                        break;
                    case R.id.action_user:
                        mViewPage2.setCurrentItem(3);
                        break;
                }

                return true;
            }
        });
        mViewPage2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        mNavigationView.getMenu().findItem(R.id.action_giohang).setChecked(true);
                        break;
                    case 2:
                        mNavigationView.getMenu().findItem(R.id.action_thongbao).setChecked(true);
                        break;
                    case 3:
                        mNavigationView.getMenu().findItem(R.id.action_user).setChecked(true);

                        break;
                }
            }
        });
    }
    private void setmViewPage2(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        mViewPage2.setAdapter(adapter);

    }
}