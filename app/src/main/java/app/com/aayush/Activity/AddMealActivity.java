package app.com.aayush.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Adapters.AddMealAdapter;
import app.com.aayush.Adapters.ItemClicklistenerInterface;
import app.com.aayush.Adapters.MealAdapter;

import app.com.aayush.Modals.Categories;
import app.com.aayush.Modals.Meal;
import app.com.aayush.R;

public class AddMealActivity extends BaseAuthenticatedActivity  {
    private GridView gridView;
    private ArrayList<Meal> gridList = new ArrayList<>();
    private ArrayList<Meal> mealList = new ArrayList<>();
    private MealAdapter mealAdapter;
    private RecyclerView mealListView;
    private Context context;
    private ImageView removeItem;
    public ItemClicklistenerInterface listener;
    private RecyclerView rView;
    private List<Categories> catList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmeal);
        setSupportActionBar(toolbar);

        mealListView = findViewById(R.id.meal_list_view);
        createListItems();
    }

    private void createListItems() {
        rView=findViewById(R.id.add_meal_recview);
        rView.setLayoutManager(new LinearLayoutManager(this));
        AddMealAdapter amAdapter=new AddMealAdapter(this,getCategoriesList());
        rView.setAdapter(amAdapter);
    }

    private List<Categories> getCategoriesList() {
        catList=new ArrayList<>();
        String catName[]={"Veg","Non-Veg","Fruits", "Vegetables", "Dairy Products", "Spices", "Oils", "Grains", "Pulses","Others"};
        for(int i=0;i<catName.length;i++){
            Categories categories=new Categories(catName[i]);
            catList.add(categories);
        }
        return catList;
    }

//        gridList.add(new Meal(R.drawable.ic_bread, "Bread"));
//        gridList.add(new Meal(R.drawable.ic_bread, "a"));
//        gridList.add(new Meal(R.drawable.ic_bread, "b"));
//        gridList.add(new Meal(R.drawable.ic_bread, "Samosa"));
//        gridList.add(new Meal(R.drawable.ic_bread, "Chips"));
//        gridList.add(new Meal(R.drawable.ic_bread, "Rice"));
//        gridList.add(new Meal(R.drawable.ic_bread, "sadasdsadDaalfasfaf"));
//        gridList.add(new Meal(R.drawable.ic_burger, "Burger"));
//        gridList.add(new Meal(R.drawable.ic_bread, "Bread"));
//        gridList.add(new Meal(R.drawable.ic_bread, "a"));
//        gridList.add(new Meal(R.drawable.ic_bread, "b"));
//        gridList.add(new Meal(R.drawable.ic_bread, "Samosa"));
//        gridList.add(new Meal(R.drawable.ic_bread, "Chips"));
//        gridList.add(new Meal(R.drawable.ic_bread, "Rice"));
//        gridList.add(new Meal(R.drawable.ic_bread, "sadasdsadDaalfasfaf"));
//        gridList.add(new Meal(R.drawable.ic_burger, "Burger"));
//        Collections.sort(gridList, new Comparator<Meal>() {
//            @Override
//            public int compare(Meal lhs, Meal rhs) {
//                return lhs.getMealName().compareTo(rhs.getMealName());
//            }
//        });
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
}




