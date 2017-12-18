package app.com.aayush.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import app.com.aayush.Activity.MainActivity;
import app.com.aayush.R;

public class MainProfileFragment extends BaseFragment {
    MainActivity activity;
    android.support.v7.widget.Toolbar toolbar;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile,container,false);
        activity= (MainActivity) getActivity();

        toolbar = activity.findViewById(R.id.include_toolbar);
        return view;
    }
}
