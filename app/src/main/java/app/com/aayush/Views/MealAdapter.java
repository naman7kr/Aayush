package app.com.aayush.Views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.aayush.Modals.Meal;
import app.com.aayush.R;



public class MealAdapter extends ArrayAdapter<Meal> {
    private Context context;
    public MealAdapter(@NonNull Context context, ArrayList<Meal> list) {
        super(context,0, list);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(context).inflate(R.layout.meal_view,parent,false);
        }
        Meal current=getItem(position);
        ImageView mealImage=listItemView.findViewById(R.id.meal_image);
        TextView mealName=listItemView.findViewById(R.id.meal_name);
        mealImage.setImageResource(current.getMealImage());
        mealName.setText(current.getMealName());
        return listItemView;

    }
}
