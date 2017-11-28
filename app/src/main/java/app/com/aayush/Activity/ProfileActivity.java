package app.com.aayush.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import app.com.aayush.R;

/**
 * Created by Stan on 11/28/2017.
 */

public class ProfileActivity extends BaseAuthenticatedActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
