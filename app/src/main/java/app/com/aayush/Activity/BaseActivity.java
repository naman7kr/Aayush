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
import app.com.aayush.Views.NavDrawer;
import android.util.DisplayMetrics;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected NavDrawer navDrawer;
    protected AayushApplication application;
    protected boolean isTablet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application=(AayushApplication)getApplication();
        DisplayMetrics metrics=getResources().getDisplayMetrics();
        isTablet=(metrics.widthPixels/metrics.density)>=600;
        Toast.makeText(getApplicationContext(),"Tab",Toast.LENGTH_SHORT).show();
    }
    public AayushApplication getYoraApplication()
    {
        return application;
    }
    @Override
    public void setContentView(@LayoutRes int layoutResId)
    {
        super.setContentView(layoutResId);
        toolbar=(Toolbar)findViewById(R.id.include_toolbar);
        if(toolbar!=null)
        {
            setSupportActionBar(toolbar);
        }
    }
    protected void setNavDrawer(NavDrawer navDrawer)
    {
        this.navDrawer=navDrawer;
        this.navDrawer.create();
        overridePendingTransition(0,0);
        View rootView=findViewById(android.R.id.content);
        rootView.setAlpha(0);
        rootView.animate().alpha(1).setDuration(450).start();
    }
    public void fadeOut(final FadeOutListener listener)
    {
        View rootView=findViewById(android.R.id.content);
        rootView.animate()
                .alpha(0)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                    }
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        listener.onFadeoutEnd();
                    }
                    @Override
                    public void onAnimationCancel(Animator animator) {
                    }
                    @Override
                    public void onAnimationRepeat(Animator animator) {
                    }
                })
                .setDuration(150)
                .start();
    }
    public Toolbar getToolbar()
    {
        return toolbar;
    }
    public interface FadeOutListener
    {
        void onFadeoutEnd();
    }
}
