package com.jjn.perfuming.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jjn.perfuming.MainFragment.BoardFragment;

import java.util.ArrayList;


public class board_PagerAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> listFragment = new ArrayList<>();

    public board_PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return listFragment.size();
    }

    public void addFragment(Fragment fragment){listFragment.add(fragment);}
}
