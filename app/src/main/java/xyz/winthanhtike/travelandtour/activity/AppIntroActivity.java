package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import xyz.winthanhtike.travelandtour.R;

/**
 * Created by winthanhtike on 7/24/16.
 */
public class AppIntroActivity extends AppIntro2{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Main Screen", "You will see hero list and change hero category by press bottom menu.", R.drawable.slide_1, R.color.slide_color));
        addSlide(AppIntroFragment.newInstance("Deatail Screen", "You can read hero spell,hero ability,hero overview nad hero detail.", R.drawable.slide_2, R.color.colorPrimary));
        addSlide(AppIntroFragment.newInstance("Hello Spell", "You can read about hero spell by pressing spell image.", R.drawable.slide_3, R.color.colorAccent));

        setFadeAnimation();

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(AppIntroActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
