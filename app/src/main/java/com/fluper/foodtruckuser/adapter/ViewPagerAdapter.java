package com.fluper.foodtruckuser.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> tabtitle = new ArrayList<>();

    public void addfragment(Fragment fragment, String tabTitle){

        this.fragmentArrayList.add(fragment);
        this.tabtitle.add(tabTitle);
    }


    public ViewPagerAdapter(FragmentManager fm){
        super(fm);

    }
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitle.get(position);
    }
}

