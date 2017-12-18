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

import java.util.ArrayList;
import java.util.List;

import app.com.aayush.Activity.MainActivity;
import app.com.aayush.R;
import app.com.aayush.Views.CardAdapter;

public class MainHomeFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;
    private  LinearLayout linearLayout;
    private ImageView cardType;
    private ImageView cardselectToggle;
    private MainActivity mainActivity;
    private List<Integer> cardTypeImg=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        //initialization
        this.view=view;
        mainActivity= (MainActivity) getActivity();
        tabLayout=view.findViewById(R.id.card_tablayout);
        viewPager=view.findViewById(R.id.card_viewpager);
        //get images to list cardTypeImg
        getCardTypeImages();
        //setAdapter
        CardAdapter adapter=new CardAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //Design Tabs
        createTabLayout();
        tabLayout.addOnTabSelectedListener(this);

        return view;
    }

    private void createTabLayout() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            linearLayout = (LinearLayout)
                    LayoutInflater.from(mainActivity).inflate(R.layout.card_tabs, tabLayout, false);
            cardType=linearLayout.findViewById(R.id.card_typeimg);
            cardselectToggle=linearLayout.findViewById(R.id.card_togglebutton);
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if(tab.isSelected())
            {
                cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_on);
                cardType.setElevation(240);
                cardType.setScaleX((float) 1.3);
                cardType.setScaleY((float) 1.3);
            }
            else
                cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_off);
            cardType.setImageResource(cardTypeImg.get(i));
            tab.setCustomView(linearLayout);
        }
    }

    private void getCardTypeImages() {
        int img[]={R.drawable.ic_calorie,R.drawable.ic_water};
        for(int i=0;i<img.length;i++)
        {
            cardTypeImg.add(img[i]);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
       cardselectToggle=tab.getCustomView().findViewById(R.id.card_togglebutton);
       cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_on);
       cardType = tab.getCustomView().findViewById(R.id.card_typeimg);
       cardType.setElevation(240);
       cardType.setScaleX((float) 1.3);
       cardType.setScaleY((float) 1.3);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        cardselectToggle=tab.getCustomView().findViewById(R.id.card_togglebutton);
        cardselectToggle.setImageResource(R.mipmap.ic_toggle_button_off);
        cardType = tab.getCustomView().findViewById(R.id.card_typeimg);
        cardType.setElevation(240);
        cardType.setScaleX((float) 1);
        cardType.setScaleY((float) 1);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
