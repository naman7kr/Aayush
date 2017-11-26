package app.com.aayush.Infrastructure;


public class User {
    private String userName;
    private String displayName;
    private String avatarURL;
    private boolean isLoggedIn;
    private boolean hasPassword;
    private String email;
    private int id;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean isHasPassword() {
        return hasPassword;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
