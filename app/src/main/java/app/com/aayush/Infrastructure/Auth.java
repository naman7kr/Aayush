package app.com.aayush.Infrastructure;

import android.content.Context;
public class Auth {
    protected Context context;
    protected User user;

    public Auth(Context context) {
        this.context = context;
        user=new User();
    }

    public User getUser() {
        return user;
    }
}
