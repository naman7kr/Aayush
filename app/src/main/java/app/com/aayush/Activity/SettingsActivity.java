package app.com.aayush.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.aayush.R;

public class SettingsActivity extends BaseAuthenticatedActivity{
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        recyclerView=findViewById(R.id.activity_settings_listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SettingAdapter settingAdapter=new SettingAdapter();

        recyclerView.setAdapter(settingAdapter);

        for(int i=0;i<20;i++)
        settingAdapter.addItem("Setting"+i);


    }

    private class SettingAdapter extends RecyclerView.Adapter<SettingViewHolder>{
        private final ArrayList<String> items;

        public SettingAdapter()
        {

            items=new ArrayList<>();
        }

        public void addItem(String name)
        {
            items.add(name);
            notifyItemInserted(items.size()-1);
        }

        public void removeItem(String name)
        {
            int position=items.indexOf(name);
            items.remove(position);
            notifyItemRemoved(position);
        }

        @Override
        public SettingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=getLayoutInflater().inflate(R.layout.activity_settings_item,parent,false);
            return new SettingViewHolder(v);
        }

        @Override
        public void onBindViewHolder(SettingViewHolder holder, int position) {
            String name=items.get(position);
            holder.item.setText(name);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    private class SettingViewHolder extends RecyclerView.ViewHolder{
        public TextView item;

        public SettingViewHolder(View itemView) {
            super(itemView);
            item= itemView.findViewById(R.id.activity_settings_item_text);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
