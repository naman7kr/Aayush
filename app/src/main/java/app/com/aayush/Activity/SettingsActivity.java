package app.com.aayush.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import app.com.aayush.R;


public class SettingsActivity extends BaseAuthenticatedActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
