package app.com.aayush.Activity;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import app.com.aayush.R;
import app.com.aayush.Views.PageAdapter;

public class MainActivity extends BaseAuthenticatedActivity
{

    private final int BACK_BUTTON_TIME=2500;
    private int backCount;
    private ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        bottomNavigationView=findViewById(R.id.navigation);
        viewPager=findViewById(R.id.viewpager);
        PageAdapter adapter=new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.main_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.main_achievement:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.main_profile:
                        viewPager.setCurrentItem(2);
                        return true;
                }
                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0)
                bottomNavigationView.setSelectedItemId(R.id.main_home);
                else if(position==1)
                    bottomNavigationView.setSelectedItemId(R.id.main_achievement);
                else
                    bottomNavigationView.setSelectedItemId(R.id.main_profile);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
//TODO: Floating Action Bar
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