package xyz.winthanhtike.travelandtour.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.ViewPagerAdapter;

/**
 * Created by winthanhtike on 6/23/16.
 */
public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment,container,false);

        initConfigView(view);

        return view;
    }

    private void initConfigView(View v){

        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        pagerAdapter.addFragment(new StrengthFragment(),"STRENGTH");
        pagerAdapter.addFragment(new AgilityFragment(),"AGILITY");
        pagerAdapter.addFragment(new IntelligenceFragment(),"INTELLIGENCE");
        viewPager.setAdapter(pagerAdapter);

    }

}
