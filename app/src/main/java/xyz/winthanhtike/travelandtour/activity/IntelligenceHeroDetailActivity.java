package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.db.DataContract;
import xyz.winthanhtike.travelandtour.data.model.IntelligenceHero;
import xyz.winthanhtike.travelandtour.utils.CustomExpendableTextView;

/**
 * Created by winthanhtike on 6/11/16.
 */
public class IntelligenceHeroDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView tvRole,tvToolbarTitle;
    private ImageView imgHero;
    private IntelligenceHero intelligenceHero;
    private CustomExpendableTextView tvExpandableOverview,tvExpendableDetail;
    private Button btnReadMoreOverview,btnReadMoreDetail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item_container);

        Intent intent = getIntent();
        intelligenceHero = (IntelligenceHero) intent.getSerializableExtra(DataContract.IntelligenceTable.TABLE_NAME);

        configsView();

        tvExpandableOverview.setText(intelligenceHero.getiHeroOverview());
        tvExpendableDetail.setText(intelligenceHero.getiHeroDetail());
        //tvRole.setText(intelligenceHero.getiHeroRole());
        tvToolbarTitle.setText(intelligenceHero.getiHeroName());
        Picasso.with(Dota2HeroApp.getContext()).load(intelligenceHero.getiHeroImageUrl()).error(R.mipmap.ic_launcher).into(imgHero);

    }

    private void configsView() {

        btnReadMoreOverview = (Button)findViewById(R.id.btn_read_more_overview);
        tvExpandableOverview = (CustomExpendableTextView) findViewById(R.id.tv_overview);
        tvExpandableOverview.setAnimationDuration(1000L);

        btnReadMoreOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpandableOverview.toggle();
                btnReadMoreOverview.setText(tvExpandableOverview.isExpanded()? R.string.read_more : R.string.read_less);
            }
        });

        btnReadMoreDetail = (Button) findViewById(R.id.btn_read_more_detail);
        tvExpendableDetail = (CustomExpendableTextView) findViewById(R.id.tv_detail);
        tvExpendableDetail.setAnimationDuration(1000L);

        btnReadMoreDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpendableDetail.toggle();
                btnReadMoreDetail.setText(tvExpendableDetail.isExpanded() ? R.string.read_more : R.string.read_less);
            }
        });

        imgHero = (ImageView)findViewById(R.id.col_img_hero);
        //tvRole = (TextView)findViewById(R.id.tv_role);
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
