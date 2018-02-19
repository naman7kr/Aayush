package app.com.aayush.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Fragments.AddMealFragment;
import app.com.aayush.Modals.Categories;
import app.com.aayush.Modals.Meal;
import app.com.aayush.R;

/**
 * Created by Stan on 1/31/2018.
 */

public class AddMealAdapter extends FragmentPagerAdapter{
    private ArrayList<Meal> list;
    public AddMealAdapter(FragmentManager fm,ArrayList<Meal> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AddMealFragment(list);
            case 1:
                return new AddMealFragment(list);
            case 2:
                return new AddMealFragment(list);
            case 3:
                return new AddMealFragment(list);
            case 4:
                return new AddMealFragment(list);
            case 5:
                return new AddMealFragment(list);
            case 6:
                return new AddMealFragment(list);
            case 7:
                return new AddMealFragment(list);
            case 8:
                return new AddMealFragment(list);
        }
        return null;
    }
    @Override
    public int getCount() {
        return 9;
    }
}