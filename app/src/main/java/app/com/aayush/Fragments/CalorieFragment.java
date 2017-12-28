package app.com.aayush.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import app.com.aayush.Activity.AddMealActivity;
import app.com.aayush.R;


public class CalorieFragment extends BaseFragment implements View.OnClickListener {
    private static final int REQUEST_MEAL = 100;
    private Button button;
    private Animation animAlpha;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_calorie,container,false);
        animAlpha = AnimationUtils.loadAnimation(getContext(),
                R.anim.anim_alpha);
        button=view.findViewById(R.id.calorie_addmeal);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.calorie_addmeal)
        {
            view.startAnimation(animAlpha);
            startActivityForResult(new Intent(getContext(),AddMealActivity.class),REQUEST_MEAL);
        }
    }
}
