package app.com.aayush.Modals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.com.aayush.R;

/**
 * Created by Stan on 2/19/2018.
 */

public class Constants {
    public static final int VEG_POS = 0;
    public static final int OTHERS_POS = 8;
    public static final int NONVEG_POS = 1;
    public static final int FRUITS_POS = 2;
    public static final int DAIRY_POS = 3;
    public static final int SPICES_POS = 4;
    public static final int OILS_POS = 5;
    public static final int GRAINS_POS = 6;
    public static final int PULSES_POS = 7;
    public static final String[] vegName={"Aloo", "Gobhi", "Paneer"};
    public static final int[] vegImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread};
    public static final String[] nonvegName={"Chicken", "Fish", "Egg"};
    public static final int[] nonvegImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread};
    public static final String[] fruitsName={"Apple", "Mango", "Guava", "Banana", "Orange"};
    public static final int[] fruitsImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread,
                                         R.drawable.ic_burger, R.drawable.ic_bread};
    public static final String[] dairyName={"Milk", "Butter", "Ghee"};
    public static final int[] dairyImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread};
    public static final String[] spicesName={"Chilli pepper", "Herb", "Table Salt"};
    public static final int[] spicesImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread};
    public static final String[] oilsName={"Coconut Oil", "Olive Oil", "Canola Oil"};
    public static final int[] oilsImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread};
    public static final String[] grainsName={"Wheet", "Spelt", "Barley", "Oat", "Rice", "Buckwheat", "Lentil"};
    public static final int[] grainsImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread,
            R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread, R.drawable.ic_bread};
    public static final String[] pulsesName={"Masoor Dal", "Chana Daal", "Arhar Daal"};
    public static final int[] pulsesImg={R.drawable.ic_bread, R.drawable.ic_burger, R.drawable.ic_bread};
    public static final String[] othersName={};
    public static final int[] othersImg={};


    public static Meals getMealListAt(int position){
        Meals meals=new Meals();
        switch (position){
            case VEG_POS:
                meals.setMealsName(vegName);
                meals.setMealsImage(vegImg);
                break;
            case NONVEG_POS:
                meals.setMealsName(nonvegName);
                meals.setMealsImage(nonvegImg);
                break;
            case FRUITS_POS:
                meals.setMealsName(fruitsName);
                meals.setMealsImage(fruitsImg);
                break;
            case DAIRY_POS:
                meals.setMealsName(dairyName);
                meals.setMealsImage(dairyImg);
                break;
            case SPICES_POS:
               meals.setMealsName(spicesName);
               meals.setMealsImage(spicesImg);
                break;
            case OILS_POS:
                meals.setMealsName(oilsName);
                meals.setMealsImage(oilsImg);
                break;
            case GRAINS_POS:
               meals.setMealsName(grainsName);
               meals.setMealsImage(grainsImg);
                break;
            case PULSES_POS:
                meals.setMealsName(pulsesName);
                meals.setMealsImage(pulsesImg);
                break;
            case OTHERS_POS:
                meals.setMealsName(othersName);
                meals.setMealsImage(othersImg);
                break;
        }
        return meals;
    }

}
