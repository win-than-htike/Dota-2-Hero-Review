package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import org.greenrobot.eventbus.EventBus;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.HomeViewPagerAdapter;
import xyz.winthanhtike.travelandtour.data.model.SearchModel;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.fragment.AgilityFragment;
import xyz.winthanhtike.travelandtour.fragment.IntelligenceFragment;
import xyz.winthanhtike.travelandtour.fragment.StrengthFragment;
import xyz.winthanhtike.travelandtour.utils.ControllerHero;

public class MainActivity extends AppCompatActivity implements ControllerHero {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.strength,
            R.drawable.agility,
            R.drawable.intelligence
    };
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupViewPager(ViewPager viewPager) {

        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                EventBus.getDefault().post(SearchModel.getInstance().getSearchHeroListByName(query));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_about_me:
                startActivity(new Intent(Dota2HeroApp.getContext(),AboutUsActivity.class));
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapStrengthHero(HeroVO hero, ImageView ivHeroImage) {
        Intent intent = StrengthHeroDetailActivity.newInstance(hero.getHeroName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(ivHeroImage,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }

    @Override
    public void onTapAgilityHero(HeroVO heroVO, ImageView imageView) {
        Intent intent = AgilityHeroDetailActivity.newInstance(heroVO.getHeroName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(imageView,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }

    @Override
    public void onTapIntellHero(HeroVO heroVO, ImageView imageView) {
        Intent intent = IntelligenceHeroDetailActivity.newInstance(heroVO.getHeroName());
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(imageView,getString(R.string.share_image_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }
}
