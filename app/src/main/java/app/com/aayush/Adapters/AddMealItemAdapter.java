package app.com.aayush.Adapters;

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

/**
 * Created by Stan on 2/1/2018.
 */

public class AddMealItemAdapter extends ArrayAdapter<Meal> {
    private LayoutInflater inflater;
    private ArrayList<Meal> list;
    private ImageView mealImage;
    private TextView mealName;

    public AddMealItemAdapter(Context context, ArrayList<Meal> list) {
        super(context,0,list);
        inflater=LayoutInflater.from(context);
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflater.inflate(R.layout.meal_view,parent,false);
        Meal current=getItem(position);
        mealImage=view.findViewById(R.id.meal_image);
         mealName=view.findViewById(R.id.meal_name);

         mealImage.setImageResource(current.getMealImage());
        mealName.setText(current.getMealName());
        return view;
    }
}
