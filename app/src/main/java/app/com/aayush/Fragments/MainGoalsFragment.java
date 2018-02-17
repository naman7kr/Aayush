package app.com.aayush.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Activity.AddMealActivity;
import app.com.aayush.Adapters.ItemClicklistenerInterface;
import app.com.aayush.Modals.Categories;
import app.com.aayush.R;
import app.com.aayush.Adapters.GoalsAdapter;


public class MainGoalsFragment extends BaseFragment {


    private RecyclerView goRecView;
    private List<Categories> list;


    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goals, container, false);
        setLayout(view);
        return view;
    }

    public void setLayout(View view) {
        goRecView = view.findViewById(R.id.goals_recyclerview);
        goRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        GoalsAdapter adapter = new GoalsAdapter(getContext(), getList(), new ItemClicklistenerInterface() {
            @Override
            public void onItemClick(View v, int position) {

            }

            @Override
            public void addItem(View v, int tag) {
                startActivityForResult(new Intent(getContext(), AddMealActivity.class),51);
            }

            @Override
            public void removeItem(int tag) {

            }
        });
        goRecView.setAdapter(adapter);
    }

    public List<Categories> getList() {
        String cat[]={"Breakfast", "Lunch","Snacks","Dinner"};
        List<Categories> catList=new ArrayList<>();
        for(int i=0;i<cat.length;i++)
        {
            Categories categories=new Categories(cat[i]);
            catList.add(categories);
        }
        return catList;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
