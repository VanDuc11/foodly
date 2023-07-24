package com.example.foodly.ViewAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foodly.Fragment.Gio_hang_Fragment;
import com.example.foodly.Fragment.Home_Fragment;
import com.example.foodly.Fragment.Thong_bao_Fragment;
import com.example.foodly.Fragment.Toi_Fragment;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Home_Fragment();
            case 1:
                return new Gio_hang_Fragment();
            case 2:
                return  new Thong_bao_Fragment();
            case 3:
                return new Toi_Fragment();
            default:
                return new Home_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
