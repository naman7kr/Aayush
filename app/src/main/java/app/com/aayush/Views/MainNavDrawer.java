package app.com.aayush.Views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.com.aayush.Activity.BaseActivity;
import app.com.aayush.Activity.MainActivity;
import app.com.aayush.Activity.SettingsActivity;
import app.com.aayush.R;

/**
 * Created by Stan on 11/26/2017.
 */

public class MainNavDrawer extends NavDrawer{
    MainNavDrawer mainNavDrawer;
    private final TextView displayNameText;
    private final ImageView avatarImage;
    public MainNavDrawer(final BaseActivity baseActivity)
    {
        super(baseActivity);
        addItem(new ActivityNavDrawerItem(MainActivity.class,"Home", R.drawable.ic_action_unread,R.id.include_main_nav_drawer_topitems));
        addItem(new ActivityNavDrawerItem(SettingsActivity.class,"Settings",R.drawable.ic_settings_black_24dp,R.id.include_main_nav_drawer_topitems));
        addItem(new BasicNavDrawerItem("Logout",R.drawable.ic_action_backspace,R.id.include_main_nav_drawer_bottomitems)
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(baseActivity,"You Have Logged Out!",Toast.LENGTH_SHORT).show();
            }
        });
        displayNameText=(TextView)navDrawerView.findViewById(R.id.include_main_nav_drawer_display_name);
        avatarImage=(ImageView)navDrawerView.findViewById(R.id.include_main_nav_drawer_avatar);
        //// TODO: 10/26/17 change avatarImage to avatarUrl from LoggedInUser
    }
}
