package app.com.aayush.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reginald.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Modals.Meal;
import app.com.aayush.R;



public class SelectedMealAdapter extends RecyclerView.Adapter<SelectedMealAdapter.SelectedViewHolder>  {
    private List<Meal> list;
    private LayoutInflater inflater;
    private ItemClicklistenerInterface clickInterface;
    private Context context;
    Dialog mDialog;
    EditSpinner qty;
    public SelectedMealAdapter(Context context, ArrayList<Meal> list) {
        this.list=list;
        inflater=LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public SelectedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.selected_meal,parent,false);
        return new SelectedViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(SelectedViewHolder holder, final int position) {
        final Meal meal=list.get(position);
        holder.mealName.setText(meal.getMealName());
        holder.mealImage.setImageResource(meal.getMealImage());

        holder.editMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog=new Dialog(context);
                mDialog.setContentView(R.layout.add_meal_dialog);
                mDialog.show();
                qty=mDialog.findViewById(R.id.dialog_qty);
                mDialog.findViewById(R.id.dialog_submit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(qty.getText().toString()!="0"){
                            meal.setQuantity(Integer.parseInt(qty.getText().toString()));
                            notifyDataSetChanged();
                        }
                        mDialog.dismiss();
                    }
                });
                mDialog.findViewById(R.id.dialog_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
            }
        });
        holder.remButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,list.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class SelectedViewHolder extends RecyclerView.ViewHolder {
        LinearLayout editMeal;
        TextView remButton;
        ImageView mealImage;
        TextView mealName;


        public SelectedViewHolder(View itemView) {
            super(itemView);
            editMeal=itemView.findViewById(R.id.meal_selected_icon);
            remButton=itemView.findViewById(R.id.meal_selected_remove);
            mealImage=itemView.findViewById(R.id.meal_selected_image);
            mealName=itemView.findViewById(R.id.meal_selected_name);

        }


    }
}
