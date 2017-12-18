package app.com.aayush.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.com.aayush.Fragments.MainAchievementFragment;
import app.com.aayush.Fragments.MainHomeFragment;
import app.com.aayush.Fragments.MainProfileFragment;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainHomeFragment();
            case 1:
                return new MainAchievementFragment();
            case 2:
                return new MainProfileFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}