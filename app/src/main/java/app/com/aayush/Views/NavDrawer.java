package app.com.aayush.Views;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.com.aayush.Activity.BaseActivity;
import app.com.aayush.R;

/**
 * Created by Stan on 11/26/2017.
 */


public class NavDrawer extends BaseActivity {
    private ArrayList<NavDrawerItem> items;
    private NavDrawerItem selectedItem;

    protected BaseActivity baseActivity;
    protected DrawerLayout drawerLayout;
    protected ViewGroup navDrawerView;

    public NavDrawer(BaseActivity activity) {
        this.baseActivity = activity;
        items = new ArrayList<>();
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        navDrawerView = (ViewGroup) activity.findViewById(R.id.nav_drawer);
        if (drawerLayout == null || navDrawerView == null)
            throw new RuntimeException("No drawerLayout or NavDrawerView");
        Toolbar toolbar = activity.getToolbar();
        toolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOpen(!isOpen());
                //  Toast.makeText(baseActivity,"NavDrawer Button",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addItem(NavDrawerItem item) {
        items.add(item);
        item.navDrawer = this;
    }

    public boolean isOpen() {
        return drawerLayout.isDrawerOpen(Gravity.START);
    }

    public void setOpen(boolean isOpen) {
        if (isOpen()) {
            drawerLayout.closeDrawer(Gravity.START);
        } else
            drawerLayout.openDrawer(Gravity.START);
    }

    public void setSelectedItem(NavDrawerItem item) {
        if (selectedItem != null)
            selectedItem.navDrawer.setSelectedItem(item);
        selectedItem = item;
        selectedItem.setSelected(true);
    }

    public void create() {
        LayoutInflater inflater = baseActivity.getLayoutInflater();
        for (NavDrawerItem item : items)
            item.inflate(inflater, navDrawerView);
    }


    public static abstract class NavDrawerItem {
        protected NavDrawer navDrawer;

        public abstract void inflate(LayoutInflater inflater, ViewGroup container);

        public abstract void setSelected(boolean isSelected);
    }

    public static class BasicNavDrawerItem extends NavDrawerItem implements View.OnClickListener {
        private String text;
        private int iconDrawable;
        private int containerId;

        private ImageView icon;
        private TextView textView;
        private View view;
        private int defaultTextColor;

        public BasicNavDrawerItem(String text, int iconDrawable, int containerId) {
            this.text = text;
            this.containerId = containerId;
            this.iconDrawable = iconDrawable;
        }

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup navDrawerView) {
            ViewGroup container = (ViewGroup) navDrawerView.findViewById(containerId);
            if (container == null) {
                throw new RuntimeException("Container not found");
            }
            view = inflater.inflate(R.layout.list_item_nav_drawer, container, false);
            container.addView(view);
            view.setOnClickListener(this);
            icon = (ImageView) view.findViewById(R.id.list_item_nav_drawer_icon);
            textView = (TextView) view.findViewById(R.id.list_item_nav_drawer_text_view);
            defaultTextColor = textView.getCurrentTextColor();
            icon.setImageResource(iconDrawable);
            textView.setText(text);

        }

        @Override
        public void setSelected(boolean isSelected) {
            if (isSelected) {
                view.setBackgroundResource(R.drawable.list_item_nav_drawer_selected_item_background);
                textView.setTextColor(navDrawer.baseActivity.getResources().getColor(R.color.list_item_nav_drawer_selected_item_text_color));
            } else {
                view.setBackground(null);
                textView.setTextColor(defaultTextColor);
            }
        }

        public void setText(String text) {
            this.text = text;
            if (view != null) {
                textView.setText(text);
            }
        }

        public void setIcon(int iconDrawable) {
            this.iconDrawable = iconDrawable;
            if (view != null) {
                icon.setImageResource(iconDrawable);
            }
        }

        @Override
        public void onClick(View view) {
            navDrawer.setSelectedItem(this);
        }
    }

    public static class ActivityNavDrawerItem extends BasicNavDrawerItem {

        private final Class targetActivity;

        public ActivityNavDrawerItem(Class targetActivity, String text,  int iconDrawable, int containerId) {
            super(text, iconDrawable, containerId);
            this.targetActivity = targetActivity;
            setIcon(iconDrawable);
        }

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup navDrawer) {
            super.inflate(inflater, navDrawer);
            if (this.navDrawer.baseActivity.getClass() == targetActivity) {
                this.navDrawer.setSelectedItem(this);
            }
        }

        @Override
        public void onClick(View view) {
            navDrawer.setOpen(false);
            final BaseActivity activity = navDrawer.baseActivity;
            if (activity.getClass() == targetActivity) {
                Log.e("Same", "SameSame");
                return;
            }
            //super.onClick(view);
            activity.fadeOut(new FadeOutListener() {
                @Override
                public void onFadeoutEnd() {
                    activity.startActivity(new Intent(activity, targetActivity));
                    activity.finish();
                }
            });

            //       Log.e("Same","SameSame");
        }

    }
}
