package app.com.aayush.Activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import app.com.aayush.Modals.Meal;
import app.com.aayush.R;
import app.com.aayush.Views.ItemClicklistenerInterface;
import app.com.aayush.Views.MealAdapter;
import app.com.aayush.Views.MealListAdapter;

public class AddMealActivity extends BaseAuthenticatedActivity implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private ArrayList<Meal> gridList = new ArrayList<>();
    private ArrayList<Meal> mealList = new ArrayList<>();
    private MealAdapter mealAdapter;
    private MealListAdapter mealListAdapter;
    private RecyclerView mealListView;
    private Context context;
    private ImageView removeItem;
    public ItemClicklistenerInterface listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmeal);
        setSupportActionBar(toolbar);
        mealListView = findViewById(R.id.meal_list_view);
        RecyclerView.ItemDecoration customItemDecorator=new EqualSpaceItemDecoration(18);
        mealListView.addItemDecoration(customItemDecorator);
        gridView = findViewById(R.id.activity_addmeal_gridview);
        mealAdapter = new MealAdapter(this, getList());
        gridView.setAdapter(mealAdapter);
        gridView.setOnItemClickListener(this);
        context = getApplicationContext();
        mealListAdapter = new MealListAdapter( mealList,listener=new ItemClicklistenerInterface() {
            @Override
            public void onItemClick(View v, int position) {
                Meal removeIcon=mealList.get(position);
                mealList.remove(removeIcon);
                mealListView.setAdapter(mealListAdapter);
                gridList.add((removeIcon));
                Collections.sort(gridList, new Comparator<Meal>() {
                    @Override
                    public int compare(Meal lhs, Meal rhs) {
                        return lhs.getMealName().compareTo(rhs.getMealName());
                    }
                });
                gridView.setAdapter(new MealAdapter(getApplicationContext(),gridList));

            }

            @Override
            public void addItem(View v, int tag) {

            }

            @Override
            public void removeItem(int tag) {

            }

        }
        );
        mealListView.setAdapter(mealListAdapter);

    }

    private ArrayList<Meal> getList() {

        //TODO: get meal gridList from firebase
        gridList.add(new Meal(R.drawable.ic_bread, "Bread"));
        gridList.add(new Meal(R.drawable.ic_bread, "a"));
        gridList.add(new Meal(R.drawable.ic_bread, "b"));
        gridList.add(new Meal(R.drawable.ic_bread, "Samosa"));
        gridList.add(new Meal(R.drawable.ic_bread, "Chips"));
        gridList.add(new Meal(R.drawable.ic_bread, "Rice"));
        gridList.add(new Meal(R.drawable.ic_bread, "sadasdsadDaalfasfaf"));
        gridList.add(new Meal(R.drawable.ic_burger, "Burger"));
        gridList.add(new Meal(R.drawable.ic_bread, "Bread"));
        gridList.add(new Meal(R.drawable.ic_bread, "a"));
        gridList.add(new Meal(R.drawable.ic_bread, "b"));
        gridList.add(new Meal(R.drawable.ic_bread, "Samosa"));
        gridList.add(new Meal(R.drawable.ic_bread, "Chips"));
        gridList.add(new Meal(R.drawable.ic_bread, "Rice"));
        gridList.add(new Meal(R.drawable.ic_bread, "sadasdsadDaalfasfaf"));
        gridList.add(new Meal(R.drawable.ic_burger, "Burger"));
        Collections.sort(gridList, new Comparator<Meal>() {
            @Override
            public int compare(Meal lhs, Meal rhs) {
                return lhs.getMealName().compareTo(rhs.getMealName());
            }
        });
        return gridList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (view.getId() == R.id.meal_icon) {
            Meal selected = gridList.get(position);
            selected.getMealName();
            Toast.makeText(this, selected.getMealName(), Toast.LENGTH_SHORT).show();
            gridList.remove(selected);
            Collections.sort(gridList, new Comparator<Meal>() {
                @Override
                public int compare(Meal lhs, Meal rhs) {
                    return lhs.getMealName().compareTo(rhs.getMealName());
                }
            });
            gridView.setAdapter(new MealAdapter(this, gridList));
            mealList.add(selected);
            mealListView.setAdapter(new MealListAdapter(mealList,listener));
        }

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("GRID_LIST",gridList);
        outState.putParcelableArrayList("MEAL_LIST",mealList);
        Log.e("msg","OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        gridList= savedInstanceState.getParcelableArrayList("GRID_LIST");
        mealList=savedInstanceState.getParcelableArrayList("MEAL_LIST");
        mealListView.setAdapter(new MealListAdapter(mealList,listener));
        gridView.setAdapter(new MealAdapter(this,gridList));
        Log.e("msg","OnRestoreInstanceState");
    }
    public class EqualSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mSpaceWidth;

        public EqualSpaceItemDecoration(int mSpaceHeight) {
            this.mSpaceWidth = mSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = mSpaceWidth;
            outRect.top = mSpaceWidth;
            outRect.left = mSpaceWidth;
            outRect.right = mSpaceWidth;
        }
    }
}




