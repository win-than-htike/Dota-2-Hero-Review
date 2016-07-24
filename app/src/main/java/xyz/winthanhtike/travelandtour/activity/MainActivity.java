package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.fragment.AgilityFragment;
import xyz.winthanhtike.travelandtour.fragment.IntelligenceFragment;
import xyz.winthanhtike.travelandtour.fragment.StrengthFragment;
import xyz.winthanhtike.travelandtour.utils.ControllerHero;

public class MainActivity extends AppCompatActivity implements ControllerHero {

    private Toolbar toolbar;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {

            StrengthFragment strengthFragment = new StrengthFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, strengthFragment).commit();

        }

        mBottomBar = BottomBar.attach(this,savedInstanceState);
        mBottomBar.setItems(R.menu.bottom_bar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId){

                    case R.id.action_strength:
                        StrengthFragment strengthFragment = new StrengthFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,strengthFragment).commit();
                        break;

                    case R.id.action_agiglity:
                        AgilityFragment agilityFragment = new AgilityFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,agilityFragment).commit();
                        break;

                    case R.id.action_intelligence:
                        IntelligenceFragment intelligenceFragment = new IntelligenceFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,intelligenceFragment).commit();
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);

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
