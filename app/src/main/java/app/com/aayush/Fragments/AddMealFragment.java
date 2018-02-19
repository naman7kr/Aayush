package app.com.aayush.Fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.reginald.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import app.com.aayush.Activity.AddMealActivity;
import app.com.aayush.Adapters.AddMealItemAdapter;
import app.com.aayush.Modals.Meal;
import app.com.aayush.R;


@SuppressLint("ValidFragment")
public class AddMealFragment extends Fragment {
    private GridView gridView;
    private static ArrayList<Meal> list=new ArrayList<>();
    private Dialog mDialog;
    private EditSpinner qty;
    private ActivityCommunicationInterface acInterface;
    public AddMealFragment(){}
    public AddMealFragment(ArrayList<Meal> list){
        this.list=list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_addmeal,container,false);
        gridView=view.findViewById(R.id.addmeal_gridview);
        acInterface= (ActivityCommunicationInterface) getContext();
        final AddMealItemAdapter adapter=new AddMealItemAdapter(getContext(),list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                mDialog=new Dialog(getContext());
                mDialog.setContentView(R.layout.add_meal_dialog);
                qty=mDialog.findViewById(R.id.dialog_qty);
                final TextView calorie=mDialog.findViewById(R.id.dialog_calorie);

                mDialog.findViewById(R.id.dialog_submit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(qty.getText().toString()!="0"){
                        Meal sel=adapter.getItem(position);
                        sel.setMealCalorie(Integer.parseInt(calorie.getText().toString()));
                        sel.setQuantity(Integer.parseInt(qty.getText().toString()));
                        acInterface.transferData(sel);
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
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity(),R.array.quantity,
                        android.R.layout.simple_spinner_item);
                qty.setAdapter(adapter);
                mDialog.show();

            }
        });
        return view;
    }



    public void setList(ArrayList<Meal> list){
        this.list=list;
    }

}
