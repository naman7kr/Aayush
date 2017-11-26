package app.com.aayush.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Fragments.CalorieFragment;
import app.com.aayush.Fragments.WaterFragment;

/**
 * Created by Stan on 11/26/2017.
 */

public class CardAdapter extends FragmentPagerAdapter {
    private final List<Fragment> listFragment= new ArrayList<>();
    public CardAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
       switch (position)
       {
           case 0:
               return new CalorieFragment();
           case 1:
               return new WaterFragment();
       }
       return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
