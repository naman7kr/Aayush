package app.com.aayush.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.aayush.R;

/**
 * Created by Stan on 11/26/2017.
 */

public class MainAchievementFragment extends BaseFragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_achievement,container,false);
        return view;
    }
}
