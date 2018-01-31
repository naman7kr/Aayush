

package app.com.aayush.Views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.aayush.Modals.Meal;
import app.com.aayush.R;



public class MealListAdapter extends RecyclerView.Adapter<MealListHolder> {
    public ArrayList<Meal> selectedMeal=new ArrayList<>();
    private ArrayList<Meal> unselectedMeal=new ArrayList<>();
    private View view;
    private int previousTag;
    public ItemClicklistenerInterface listener;


    public MealListAdapter(ArrayList<Meal> selectedMeal,ItemClicklistenerInterface listener) {
        this.selectedMeal=selectedMeal;
        this.listener=listener;
    }

    @Override
    public MealListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.selected_meal, parent, false);
        this.view=itemView;


        return new MealListHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(MealListHolder holder, int position) {
        Meal current=selectedMeal.get(position);
        holder.selectedMealName.setText(current.getMealName());
        holder.selectedMealImage.setImageResource(current.getMealImage());

    }
    @Override
    public int getItemCount() {
        return selectedMeal.size();
    }


}
class MealListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView selectedMealName;
    protected ImageView selectedMealImage;
    protected LinearLayout selectedMealIcon;


    public MealListHolder(View itemView,ItemClicklistenerInterface listener) {
        super(itemView);
        selectedMealName=itemView.findViewById(R.id.selected_meal_name);
        selectedMealImage=itemView.findViewById(R.id.selected_meal_image);
        selectedMealIcon=itemView.findViewById(R.id.meal_selected_icon);
        selectedMealIcon.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

    }
}


//package app.com.aayush.Views;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//import app.com.aayush.Activity.AddMealActivity;
//import app.com.aayush.Modals.Meal;
//import app.com.aayush.R;
//
//
//
//public class MealListAdapter extends ArrayAdapter<Meal> implements View.OnClickListener {
//    public ArrayList<Meal> selectedMeal=new ArrayList<>();
//    private ArrayList<Meal> unselectedMeal=new ArrayList<>();
//    private View view;
//    private int previousTag;
//    public ItemClicklistenerInterface listener;
//    protected TextView selectedMealName;
//    protected ImageView selectedMealImage;
//    private Context context;
//    private GridView mealListView;
//    private LinearLayout mealIcon;
//
//    public MealListAdapter(Context context,ArrayList<Meal> selectedMeal,View view,ItemClicklistenerInterface listener) {
//        super(context,0,selectedMeal);
//        this.selectedMeal=selectedMeal;
//        this.unselectedMeal=unselectedMeal;
//        this.listener=listener;
//        this.context=context;
//        this.mealListView= (GridView) view;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View listItemView=convertView;
//
//        {
//            listItemView= LayoutInflater.from(context).inflate(R.layout.selected_meal,parent,false);
//        }
//
//
//        Meal current=getItem(position);
//        selectedMealName=listItemView.findViewById(R.id.selected_meal_name);
//        selectedMealImage=listItemView.findViewById(R.id.selected_meal_image);
//        selectedMealName.setText(current.getMealName());
//        selectedMealImage.setImageResource(current.getMealImage());
//        mealIcon=listItemView.findViewById(R.id.meal_selected_icon);
//        mealIcon.setTag(position);
//        mealIcon.setOnClickListener(this);
//
//        return listItemView;
//    }
//
//    @Override
//    public void onClick(View view) {
//        listener.onItemClick(view, (Integer) view.getTag());
//    }
//}