package app.com.aayush.Activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import app.com.aayush.Fragments.MainAchievementFragment;
import app.com.aayush.Fragments.MainHomeFragment;
import app.com.aayush.Fragments.ProfileFragment;
import app.com.aayush.R;

public class MainActivity extends BaseAuthenticatedActivity
{
    private ViewPager viewPager;
    private final int BACK_BUTTON_TIME=2500;
    private int backCount;
    private AHBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation=findViewById(R.id.bottom_navigation);

       bottomNavigation.addItem(new AHBottomNavigationItem("Home",R.drawable.ic_home_black_24dp));
        bottomNavigation.addItem(new AHBottomNavigationItem("Achievements",R.drawable.ic_action_person));
       bottomNavigation.addItem(new AHBottomNavigationItem("Profile",R.drawable.ic_action_camera));


        Toolbar toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {

            public boolean onTabSelected(int position, boolean wasSelected) {
                Fragment selectFragment=null;
                if(position==0)
                    selectFragment=new MainHomeFragment();
                if(position==1)
                    selectFragment=new MainAchievementFragment();
                if(position==2)
                    selectFragment=new ProfileFragment();
                if(selectFragment!=null) {
                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectFragment);
                    transaction.commit();
                    return true;
                }
                else
                    return false;
            }
        });
        bottomNavigation.setCurrentItem(0);
        backCount=0;
    }
    @Override
    public void onBackPressed() {
        if(backCount==0)
        {
            Toast.makeText(this,"Press Back Button to close the app",Toast.LENGTH_SHORT).show();
            backCount++;
            startThread();
        }
        else
        {
            finish();
        }
    }
    void startThread()
    {
        new BackPressThread();
    }
    class BackPressThread implements Runnable
    {
        public BackPressThread()
        {
            Thread thread=new Thread(this);
            thread.start();
        }
        @Override
        public void run() {
            try {
                Thread.sleep(BACK_BUTTON_TIME);
                backCount=0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the nu; this adds items to the action bar if it is pres.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
/*
 FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
<android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentEnd="true"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@android:drawable/ic_dialog_email" />
        */