package app.com.aayush.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.com.aayush.Activity.MainActivity;
import app.com.aayush.R;
import app.com.aayush.Views.CardAdapter;

public class HomeFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;
    private LinearLayout linearLayout;
    private ImageView cardType;
    private ImageView cardselectToggle;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        this.view=view;
        tabLayout=view.findViewById(R.id.card_tablayout);
        viewPager=view.findViewById(R.id.card_viewpager);
        CardAdapter adapter=new CardAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
        linearLayout = (LinearLayout)
                LayoutInflater.from(getActivity()).inflate(R.layout.card_tabs, tabLayout, false);
        cardType=linearLayout.findViewById(R.id.card_typeimg);
        cardselectToggle=linearLayout.findViewById(R.id.card_togglebutton);
         for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
             linearLayout = (LinearLayout)
                     LayoutInflater.from(getActivity()).inflate(R.layout.card_tabs, tabLayout, false);
             cardType=linearLayout.findViewById(R.id.card_typeimg);
             cardselectToggle=linearLayout.findViewById(R.id.card_togglebutton);
             if(tab.isSelected())
             {

                 cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_on);
             }
             else
             {
                cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_off);
             }
             cardType.setImageResource(R.mipmap.ic_launcher);
            tab.setCustomView(linearLayout);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        linearLayout = (LinearLayout)
                LayoutInflater.from(getActivity()).inflate(R.layout.card_tabs, tabLayout, false);
        cardselectToggle=linearLayout.findViewById(R.id.card_togglebutton);
        cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_on);
        cardType.setImageResource(R.mipmap.ic_launcher);
           tab.setCustomView(linearLayout);

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        linearLayout = (LinearLayout)
                LayoutInflater.from(getActivity()).inflate(R.layout.card_tabs, tabLayout, false);
        cardselectToggle=linearLayout.findViewById(R.id.card_togglebutton);
        cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_off);
        cardType.setImageResource(R.mipmap.ic_launcher);
        tab.setCustomView(linearLayout);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
