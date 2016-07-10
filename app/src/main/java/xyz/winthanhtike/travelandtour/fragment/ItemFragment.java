package xyz.winthanhtike.travelandtour.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.ItemViewPagerAdapter;

/**
 * Created by winthanhtike on 6/23/16.
 */
public class ItemFragment extends Fragment {

    private ViewPager carryViewPager;
    private TabLayout carryTabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_fragment,container,false);

        carryViewPager = (ViewPager)view.findViewById(R.id.carry_viewpager);
        setupViewPager(carryViewPager);

        carryTabLayout = (TabLayout)view.findViewById(R.id.carry_tabs);
        carryTabLayout.setupWithViewPager(carryViewPager);

        return view;

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    private void setupViewPager(ViewPager viewPager) {

        ItemViewPagerAdapter pagerAdapter = new ItemViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(BasicItemFragment.getInstance(),"Basic Item");
        pagerAdapter.addFragment(new UpgradeItemFragment(),"Upgrade Item");
        viewPager.setAdapter(pagerAdapter);

    }

}
