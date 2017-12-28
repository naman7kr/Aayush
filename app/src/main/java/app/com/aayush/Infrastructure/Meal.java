package app.com.aayush.Infrastructure;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Stan on 12/27/2017.
 */

@SuppressLint("ParcelCreator")
public class Meal implements Parcelable {
    private int mealImage;
    private String mealName;

    public Meal(int mealImage, String mealName) {
        this.mealImage = mealImage;
        this.mealName = mealName;
    }

    public void setMealImage(int mealImage) {
        this.mealImage = mealImage;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getMealImage() {

        return mealImage;
    }

    public String getMealName() {
        return mealName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
