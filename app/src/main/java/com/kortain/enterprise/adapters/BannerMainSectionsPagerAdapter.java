package com.kortain.enterprise.adapters;

/**
 * Created by satiswardash on 05/12/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kortain.enterprise.App;
import com.kortain.enterprise.fragments.BannerMainPlaceholderFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class BannerMainSectionsPagerAdapter extends FragmentPagerAdapter {

    public BannerMainSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a BannerMainPlaceholderFragment (defined as a static inner class below).
        return BannerMainPlaceholderFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return App.images.length;
    }


}
