package app.com.aayush.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import app.com.aayush.Modals.Meal;
import app.com.aayush.R;

/**
 * Created by Stan on 1/30/2018.
 */

public class SelectedListAdapter extends RecyclerView.Adapter<SelectedListAdapter.SelectedViewHolder> {
    private List<Meal> list;
    private LayoutInflater inflater;
    private ItemClicklistenerInterface clickInterface;
    public SelectedListAdapter(Context context, List<Meal> list, ItemClicklistenerInterface clickInterface) {
        this.list=list;
       inflater=LayoutInflater.from(context);
       this.clickInterface=clickInterface;
    }

    @Override
    public SelectedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.goals_child_view,parent,false);
        return new SelectedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectedViewHolder holder, int position) {
        Meal meal=list.get(position);
        holder.itemName.setText(meal.getMealName());
        holder.remItem.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SelectedViewHolder extends RecyclerView.ViewHolder{
        private TextView itemName;
        private TextView remItem;
        public SelectedViewHolder(View itemView) {
            super(itemView);
            itemName=itemView.findViewById(R.id.goals_selected_item);
            remItem=itemView.findViewById(R.id.goals_remove_item);
            remItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickInterface.removeItem(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(),list.size());
                }
            });
        }
    }
}
