package app.com.aayush.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Modals.Categories;
import app.com.aayush.Modals.Meal;
import app.com.aayush.R;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalsViewHolder>{
    private LayoutInflater inflater;
    private List<Categories> titles;
    private List<Meal>[] selected;
    private RecyclerView selrView;
    private Context context;
    private ItemClicklistenerInterface clickInterface;
    public GoalsAdapter(Context context, List<Categories> titles, ItemClicklistenerInterface clickInterface){
        inflater=LayoutInflater.from(context);
        this.titles=titles;
        this.context=context;
        selected=new ArrayList[100];
        for(int i=0;i<100;i++)
            selected[i]=new ArrayList<>();
        this.clickInterface=clickInterface;

    }
    @Override
    public GoalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.goals_parent_view,parent,false);


        return new GoalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoalsViewHolder holder, final int position) {

        holder.title.setText(titles.get(position).getTitle());
        holder.addButton.setTag(position);
        holder.selrView.setLayoutManager(new LinearLayoutManager(context));
        SelectedListAdapter adapter=new SelectedListAdapter(context, holder.getList(), new ItemClicklistenerInterface() {
            @Override
            public void onItemClick(View v, int position) {

            }

            @Override
            public void addItem(View v, int tag) {

            }

            @Override
            public void removeItem(int tag) {
                Log.e("LOL", String.valueOf(tag));
                selected[position].remove(tag);
            }
        });
        holder.selrView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
    class GoalsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        RecyclerView selrView;
        ImageView addButton;

        public GoalsViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.goals_meal_time);
            addButton=itemView.findViewById(R.id.goals_add_food);
            selrView=itemView.findViewById(R.id.goals_selected_rview);
            selrView.setVisibility(View.GONE);
            addButton.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        public List<Meal> getList() {
            String sel[]={"tea", "coffee", "lol"};

            selected[getAdapterPosition()].clear();
            for(int i=0;i<sel.length;i++){
                Meal meal=new Meal();
                meal.setMealName(sel[i]);
                selected[getAdapterPosition()].add(meal);
            }
            return selected[getAdapterPosition()];
        }

        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.goals_itemlayout){
                if(selrView.getVisibility()==View.GONE)
                {
                    selrView.setVisibility(View.VISIBLE);
                }
                else
                {
                    selrView.setVisibility(View.GONE);
                }
            }
            if(v.getId()==R.id.goals_add_food){
                clickInterface.addItem(v, (Integer) v.getTag());
            }
        }
    }
}
