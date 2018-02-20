package app.com.aayush.Activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.view.View;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import app.com.aayush.Adapters.AddMealAdapter;
import app.com.aayush.Adapters.SelectedMealAdapter;
import app.com.aayush.Fragments.ActivityCommunicationInterface;
import app.com.aayush.Fragments.AddMealFragment;
import app.com.aayush.Modals.Constants;
import app.com.aayush.Modals.Meal;
import app.com.aayush.R;

public class AddMealActivity extends BaseAuthenticatedActivity implements View.OnClickListener, ActivityCommunicationInterface {

    private ViewPager viewCategories;
    private static ArrayList<Meal>[] list = new ArrayList[1000];
    private AddMealAdapter adapter;
    private RecyclerView rSelMeal;
    private ArrayList<Meal> selList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmeal);
        setSupportActionBar(toolbar);
        for (int i = 0; i < 100; i++) {
            list[i] = new ArrayList<>();
        }
        rSelMeal=findViewById(R.id.meal_selected_rview);
        rSelMeal.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));
        SelectedMealAdapter smAdapter=new SelectedMealAdapter(this,getSelectedList());
        rSelMeal.setAdapter(smAdapter);
        viewCategories = findViewById(R.id.meal_categories_viewpager);

        adapter = new AddMealAdapter(getSupportFragmentManager(), getList(0));
        viewCategories.setAdapter(adapter);
        categoriesChange();
    }

    private ArrayList<Meal> getSelectedList() {
            return selList;
    }


    private void categoriesChange() {
        findViewById(R.id.veg).setOnClickListener(this);
        findViewById(R.id.non_veg).setOnClickListener(this);
        findViewById(R.id.fruits).setOnClickListener(this);
        findViewById(R.id.dairy).setOnClickListener(this);
        findViewById(R.id.spices).setOnClickListener(this);
        findViewById(R.id.oils).setOnClickListener(this);
        findViewById(R.id.grains).setOnClickListener(this);
        findViewById(R.id.pulses).setOnClickListener(this);
        findViewById(R.id.others).setOnClickListener(this);

    }
    @Override
    public void transferData(Meal meal) {
        Log.e("LOL", String.valueOf(meal.getQuantity()));
        selList.add(meal);
        rSelMeal.setAdapter(new SelectedMealAdapter(this,selList));
    }
    private ArrayList<Meal> getList(int position) {
        list[position].clear();

        for (int i = 0; i < Constants.getMealListAt(position).getMealsName().length; i++) {
            Meal meal = new Meal();

            meal.setMealName(Constants.getMealListAt(position).getMealsName()[i]);
            meal.setMealImage(Constants.getMealListAt(position).getMealsImage()[i]);

            list[position].add(meal);
        }

        Collections.sort(list[position], new Comparator<Meal>() {
            @Override
            public int compare(Meal lhs, Meal rhs) {
                return lhs.getMealName().compareTo(rhs.getMealName());
            }
        });
        return list[position];
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.veg) {
            ArrayList<Meal> list1;
            list1 = getList(Constants.VEG_POS);
            ((AddMealFragment) adapter.getItem(Constants.VEG_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.VEG_POS);
        }
        if (v.getId() == R.id.non_veg) {
            ArrayList<Meal> list1 = getList(Constants.NONVEG_POS);
            ((AddMealFragment) adapter.getItem(Constants.NONVEG_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.NONVEG_POS);
        }
        if (v.getId() == R.id.fruits) {

            ArrayList<Meal> list1 = getList(Constants.FRUITS_POS);
            ((AddMealFragment) adapter.getItem(Constants.FRUITS_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.FRUITS_POS);

        }
        if (v.getId() == R.id.dairy) {
            ArrayList<Meal> list1 = getList(Constants.DAIRY_POS);
            ((AddMealFragment) adapter.getItem(Constants.DAIRY_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.DAIRY_POS);
        }
        if (v.getId() == R.id.spices) {
            ArrayList<Meal> list1 = getList(Constants.SPICES_POS);
            ((AddMealFragment) adapter.getItem(Constants.SPICES_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.SPICES_POS);
        }
        if (v.getId() == R.id.oils) {
            ArrayList<Meal> list1 = getList(Constants.OILS_POS);
            ((AddMealFragment) adapter.getItem(Constants.OILS_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.OILS_POS);
        }
        if (v.getId() == R.id.grains) {
            ArrayList<Meal> list1 = getList(Constants.GRAINS_POS);
            ((AddMealFragment) adapter.getItem(Constants.GRAINS_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.GRAINS_POS);
        }
        if (v.getId() == R.id.pulses) {
            ArrayList<Meal> list1 = getList(Constants.PULSES_POS);
            ((AddMealFragment) adapter.getItem(Constants.PULSES_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.PULSES_POS);
        }
        if (v.getId() == R.id.others) {
            ArrayList<Meal> list1 = getList(Constants.OTHERS_POS);
            ((AddMealFragment) adapter.getItem(Constants.OTHERS_POS)).setList(list1);
            viewCategories.setAdapter(new AddMealAdapter(getSupportFragmentManager(), list1));
            viewCategories.setCurrentItem(Constants.OTHERS_POS);
        }
    }


}
//        gridView = findViewById(R.id.activity_addmeal_gridview);
//        mealAdapter = new MealAdapter(this, getList());
//        gridView.setAdapter(mealAdapter);
//        gridView.setOnItemClickListener(this);
//        context = getApplicationContext();
//        mealListAdapter = new MealListAdapter( mealList,listener=new ItemClicklistenerInterface() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Meal removeIcon=mealList.get(position);
//                mealList.remove(removeIcon);
//                mealListView.setAdapter(mealListAdapter);
//                gridList.add((removeIcon));
//                Collections.sort(gridList, new Comparator<Meal>() {
//                    @Override
//                    public int compare(Meal lhs, Meal rhs) {
//                        return lhs.getMealName().compareTo(rhs.getMealName());
//                    }
//                });
//                gridView.setAdapter(new MealAdapter(getApplicationContext(),gridList));
//
//            }
//
//            @Override
//            public void addItem(View v, int tag) {
//
//            }
//
//            @Override
//            public void removeItem(int tag) {
//
//            }
//
//        }
//        );
//        mealListView.setAdapter(mealListAdapter);
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//        if (view.getId() == R.id.meal_icon) {
//            Meal selected = gridList.get(position);
//            selected.getMealName();
//            Toast.makeText(this, selected.getMealName(), Toast.LENGTH_SHORT).show();
//            gridList.remove(selected);
//            Collections.sort(gridList, new Comparator<Meal>() {
//                @Override
//                public int compare(Meal lhs, Meal rhs) {
//                    return lhs.getMealName().compareTo(rhs.getMealName());
//                }
//            });
//            gridView.setAdapter(new MealAdapter(this, gridList));
//            mealList.add(selected);
//            mealListView.setAdapter(new MealListAdapter(mealList,listener));
//        }
//    }
//        RecyclerView.ItemDecoration customItemDecorator=new EqualSpaceItemDecoration(18);
//        mealListView.addItemDecoration(customItemDecorator);
//    public class EqualSpaceItemDecoration extends RecyclerView.ItemDecoration {
//
//        private final int mSpaceWidth;
//
//        public EqualSpaceItemDecoration(int mSpaceHeight) {
//            this.mSpaceWidth = mSpaceHeight;
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
//                                   RecyclerView.State state) {
//            outRect.bottom = mSpaceWidth;
//            outRect.top = mSpaceWidth;
//            outRect.left = mSpaceWidth;
//            outRect.right = mSpaceWidth;
//        }
//    }





