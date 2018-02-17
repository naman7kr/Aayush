package app.com.aayush.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Modals.Categories;
import app.com.aayush.Modals.Meal;
import app.com.aayush.R;

/**
 * Created by Stan on 1/31/2018.
 */

public class AddMealAdapter extends RecyclerView.Adapter<AddMealAdapter.AddMealViewHolder> {
    private LayoutInflater inflater;
    private List<Categories> categories;
    private ArrayList<Meal> []meals;
    private Context context;
    private static GridView prgView;
    public AddMealAdapter(Context context, List<Categories> cat) {
        inflater=LayoutInflater.from(context);
        this.categories=cat;
        this.context=context;
        meals=new ArrayList[100];
        for(int i=0;i<100;i++){
            meals[i]=new ArrayList<>();
        }
    }

    @Override
    public AddMealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.add_meal_categories,parent,false);
        return new AddMealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddMealViewHolder holder, int position) {
        Categories current=categories.get(position);
        holder.catName.setText(current.getTitle());
        AddMealItemAdapter adapter=new AddMealItemAdapter(context, getList(position));
        //enable gridview scroll
        holder.gView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }

        });
        holder.gView.setVisibility(View.GONE);
        holder.gView.setAdapter(adapter);
    }

    private ArrayList<Meal> getList(int position) {
        String food[]={"Rice", "Dal", "Aloo", "Burger"};
        meals[position].clear();
        for(int i=0;i<food.length;i++){
            Meal items=new Meal();
            items.setMealName(food[i]);
            items.setMealImage(R.drawable.ic_burger);
            meals[position].add(items);
        }
        return meals[position];
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class AddMealViewHolder extends RecyclerView.ViewHolder{
        private TextView catName;
        private RelativeLayout container;
        private GridView gView;


        public AddMealViewHolder(View itemView) {
            super(itemView);
            catName=itemView.findViewById(R.id.add_meal_cat_name);
            container=itemView.findViewById(R.id.add_meal_categories_layout);
            gView=itemView.findViewById(R.id.addmeal_gridview);

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(prgView!=null&&prgView.getVisibility()==View.VISIBLE){
                        Log.e("LOL", String.valueOf(prgView.getVisibility()));
                        prgView.setVisibility(View.GONE);
                    }
                    if(gView.getVisibility()==View.GONE){
                        gView.setVisibility(View.VISIBLE);
                        prgView=gView;
                    }
                    else{
                        gView.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}

