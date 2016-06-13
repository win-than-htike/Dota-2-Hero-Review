package xyz.winthanhtike.travelandtour.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.ViewPagerAdapter;
import xyz.winthanhtike.travelandtour.fragment.IntelligenceFragment;
import xyz.winthanhtike.travelandtour.fragment.StrengthFragment;
import xyz.winthanhtike.travelandtour.fragment.AgilityFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager){

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new StrengthFragment(),"STRENGTH");
        pagerAdapter.addFragment(new AgilityFragment(),"AGILITY");
        pagerAdapter.addFragment(new IntelligenceFragment(),"INTELLIGENCE");
        viewPager.setAdapter(pagerAdapter);


    }
}
