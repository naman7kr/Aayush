package app.com.aayush.Infrastructure;

import android.app.Application;

/**
 * Created by Stan on 11/26/2017.
 */

public class AayushApplication extends Application{
    private Auth auth;
    @Override
    public void onCreate()
    {
        super.onCreate();
        auth=new Auth(this);
    }

    public Auth getAuth() {
        return auth;
    }
}
