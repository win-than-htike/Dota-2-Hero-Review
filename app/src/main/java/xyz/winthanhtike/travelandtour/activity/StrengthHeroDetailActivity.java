package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.db.DataContract;
import xyz.winthanhtike.travelandtour.model.StrengthHero;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class StrengthHeroDetailActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView tvOverview,tvDetail,tvToolbarTitle;
    private ImageView imgHero;
    private StrengthHero strengthHero;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item_container);

        Intent intent = getIntent();
        strengthHero = (StrengthHero) intent.getSerializableExtra(DataContract.StrengthTable.TABLE_NAME);

        configsView();

        tvOverview.setText(strengthHero.getSheroOverview());
        tvDetail.setText(strengthHero.getSheroDetail());
        tvToolbarTitle.setText(strengthHero.getSheroName());
        Picasso.with(getApplicationContext()).load(strengthHero.getSheroImageUrl()).error(R.mipmap.ic_launcher).into(imgHero);

    }

    private void configsView() {

        tvOverview = (TextView)findViewById(R.id.tv_overview);
        tvDetail = (TextView)findViewById(R.id.tv_detail);
        imgHero = (ImageView)findViewById(R.id.col_img_hero);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitleEnabled(false);
        toolbarAndTitle();

    }

    private void toolbarAndTitle() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
