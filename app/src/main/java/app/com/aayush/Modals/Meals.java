package app.com.aayush.Modals;

/**
 * Created by Stan on 2/20/2018.
 */

public class Meals  {
    public String[] mealsName;
    public int[] mealsImage;

    public void setMealsName(String[] mealsName) {
        this.mealsName = mealsName;
    }

    public void setMealsImage(int[] mealsImage) {
        this.mealsImage = mealsImage;
    }

    public String[] getMealsName() {

        return mealsName;
    }

    public int[] getMealsImage() {
        return mealsImage;
    }
}
