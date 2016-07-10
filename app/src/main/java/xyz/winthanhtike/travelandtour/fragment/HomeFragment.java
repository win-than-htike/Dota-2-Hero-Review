package xyz.winthanhtike.travelandtour.fragment;


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

/**
 * Created by winthanhtike on 6/23/16.
 */
public class HomeFragment extends Fragment implements BasicItemFragment.ControllerBasicItem{

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

        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new StrengthFragment(),"STRENGTH");
        pagerAdapter.addFragment(new AgilityFragment(),"AGILITY");
        pagerAdapter.addFragment(new IntelligenceFragment(),"INTELLIGENCE");
        viewPager.setAdapter(pagerAdapter);

    }


    @Override
    public void onTapBasicItem(BasicItemVO basicItemVO, ImageView ivBasicItemImage) {
        Intent intent = BasicItemDetailActivity.newInstance(basicItemVO.getbItemName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),new Pair(ivBasicItemImage,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(getActivity(),intent,activityOptions.toBundle());
    }
}
