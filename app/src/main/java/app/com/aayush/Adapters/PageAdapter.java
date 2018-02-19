package app.com.aayush.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.com.aayush.Fragments.MainGoalsFragment;
import app.com.aayush.Fragments.MainProfileFragment;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainGoalsFragment();
            case 1:
                return new MainProfileFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}