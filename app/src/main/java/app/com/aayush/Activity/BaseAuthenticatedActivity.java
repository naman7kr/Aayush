package app.com.aayush.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Stan on 11/26/2017.
 */

public class BaseAuthenticatedActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!application.getAuth().getUser().isLoggedIn())
        {
            startActivity(new Intent(this,LoginActivity.class));
            finish();
            return;
        }
    }
}
