package app.com.aayush.Activity;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import app.com.aayush.Infrastructure.AayushApplication;
import app.com.aayush.R;

import android.util.DisplayMetrics;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected AayushApplication application;
    protected boolean isTablet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application=(AayushApplication)getApplication();
        DisplayMetrics metrics=getResources().getDisplayMetrics();
        //check if Tablet
        isTablet=(metrics.widthPixels/metrics.density)>=600;
    }
    public AayushApplication getYoraApplication()
    {
        return application;
    }
    @Override
    public void setContentView(@LayoutRes int layoutResId)
    {
        super.setContentView(layoutResId);

    }
}
