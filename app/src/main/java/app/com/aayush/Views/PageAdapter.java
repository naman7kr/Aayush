package app.com.aayush.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.com.aayush.Fragments.AchievementFragment;
import app.com.aayush.Fragments.HomeFragment;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new AchievementFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}