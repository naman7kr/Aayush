package app.com.aayush.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.R;

public class MainGoalsFragment extends BaseFragment implements View.OnClickListener {
    private  View view;
    private LinearLayout brLayout;
    private LinearLayout luLayout;
    private LinearLayout snLayout;
    private LinearLayout diLayout;

    private static List<String> itemList =new ArrayList<>();
    private ListView brListView;
    private ListView luListView;
    private ListView snListView;
    private ListView diListView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_goals,container,false);
        //initialization
        brListView =view.findViewById(R.id.list_view_breakfast);
        luListView=view.findViewById(R.id.list_view_lunch);
        snListView=view.findViewById(R.id.list_view_snacks);
        diListView=view.findViewById(R.id.list_view_dinner);


        brLayout=view.findViewById(R.id.goals_breakfast_layout);
        luLayout=view.findViewById(R.id.goals_lunch_layout);
        snLayout=view.findViewById(R.id.goals_snacks_layout);
        diLayout=view.findViewById(R.id.goals_dinner_layout);

        brListView.setVisibility(View.GONE);
        luListView.setVisibility(View.GONE);
        snListView.setVisibility(View.GONE);
        diListView.setVisibility(View.GONE);

        this.view=view;
        getList();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), R.layout.goals_item_list, itemList);
        brListView.setAdapter(adapter);
        getList();
        luListView.setAdapter(adapter);
        getList();
        snListView.setAdapter(adapter);
        getList();
        diListView.setAdapter(adapter);

        brLayout.setOnClickListener(this);
        luLayout.setOnClickListener(this);
        snLayout.setOnClickListener(this);
        diLayout.setOnClickListener(this);
        return view;
    }

    private void getList() {
        String []item={"-tea", "-Coffee"};
        for(int i=0;i<item.length;i++)
        {
            itemList.add(item[i]);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.goals_breakfast_layout)
        {
            if(brListView.getVisibility()==View.VISIBLE)
            {
                brListView.setVisibility(View.GONE);
            }
            else
            {
                brListView.setVisibility(View.VISIBLE);
            }
        }
        if(v.getId()==R.id.goals_lunch_layout)
        {
            if(luListView.getVisibility()==View.VISIBLE)
            {
                luListView.setVisibility(View.GONE);
            }
            else
            {
                luListView.setVisibility(View.VISIBLE);
            }
        }
        if(v.getId()==R.id.goals_snacks_layout)
        {
            if(snListView.getVisibility()==View.VISIBLE)
            {
                snListView.setVisibility(View.GONE);
            }
            else
            {
                snListView.setVisibility(View.VISIBLE);
            }
        }
        if(v.getId()==R.id.goals_dinner_layout)
        {
            if(diListView.getVisibility()==View.VISIBLE)
            {
                diListView.setVisibility(View.GONE);
            }
            else
            {
                diListView.setVisibility(View.VISIBLE);
            }
        }
    }
}
