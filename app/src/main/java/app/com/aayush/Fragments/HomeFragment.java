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
    private static LinearLayout linearLayout;
    static ImageView cardType;
    static ImageView cardselectToggle;
    private MainActivity mainActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        this.view=view;
        mainActivity= (MainActivity) getActivity();
        tabLayout=view.findViewById(R.id.card_tablayout);
        viewPager=view.findViewById(R.id.card_viewpager);
        CardAdapter adapter=new CardAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            linearLayout = (LinearLayout)
                    LayoutInflater.from(mainActivity).inflate(R.layout.card_tabs, tabLayout, false);
            cardType=linearLayout.findViewById(R.id.card_typeimg);
            cardselectToggle=linearLayout.findViewById(R.id.card_togglebutton);
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if(tab.isSelected())
                cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_on);
            else
                cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_off);
            Log.e("lol","wtf");
            cardType.setImageResource(R.mipmap.ic_launcher);
            tab.setCustomView(linearLayout);
        }
        tabLayout.addOnTabSelectedListener(this);
        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
       cardselectToggle=tab.getCustomView().findViewById(R.id.card_togglebutton);
       cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_on);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        cardselectToggle=tab.getCustomView().findViewById(R.id.card_togglebutton);
        cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_off);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
