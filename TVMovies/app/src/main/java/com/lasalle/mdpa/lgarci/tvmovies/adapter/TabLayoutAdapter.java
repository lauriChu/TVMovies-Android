package com.lasalle.mdpa.lgarci.tvmovies.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lasalle.mdpa.lgarci.tvmovies.activity.form.FormActivity;
import com.lasalle.mdpa.lgarci.tvmovies.activity.form.fragment.TVShowFormFragment;

/**
 * Created by FurruPi on 2/2/17.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return position == 0 ? new TVShowFormFragment() : new FormActivity.MovieFormFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? FormActivity.TV_SHOW_TITLE : FormActivity.MOVIE_TITLE;
    }

    @Override
    public int getCount() {
        return 2;
    }
}