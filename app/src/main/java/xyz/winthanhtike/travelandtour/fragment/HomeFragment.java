package xyz.winthanhtike.travelandtour.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.activity.BasicItemDetailActivity;
import xyz.winthanhtike.travelandtour.adapter.HomeViewPagerAdapter;
import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;

/**
 * Created by winthanhtike on 6/23/16.
 */
public class HomeFragment extends Fragment{

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.strength,
            R.drawable.agility,
            R.drawable.intelligence
    };

    private ControllerHero controllerHero;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment,container,false);

        initConfigView(view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controllerHero = (ControllerHero) context;
    }

    private void initConfigView(View v){

        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupViewPager(ViewPager viewPager) {

        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new StrengthFragment());
        pagerAdapter.addFragment(new AgilityFragment());
        pagerAdapter.addFragment(new IntelligenceFragment());
        viewPager.setAdapter(pagerAdapter);

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    public interface ControllerHero{
        void onTapStrengthHero(HeroVO hero,ImageView ivHeroImage);
        void onTapAgilityHero(HeroVO hero,ImageView ivHeroImage);
        void onTapIntellHero(HeroVO hero,ImageView ivHeroImage);
    }

}
