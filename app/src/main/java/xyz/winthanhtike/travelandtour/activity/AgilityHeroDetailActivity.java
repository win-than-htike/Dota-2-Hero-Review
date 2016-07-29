package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import me.drakeet.materialdialog.MaterialDialog;
import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.HeroSpellRVAdapter;
import xyz.winthanhtike.travelandtour.data.model.AgilityHeroModel;
import xyz.winthanhtike.travelandtour.data.vos.HeroSpellVO;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.utils.CustomExpendableTextView;
import xyz.winthanhtike.travelandtour.utils.ItemClickListener;

/**
 * Created by winthanhtike on 6/11/16.
 */
public class AgilityHeroDetailActivity extends AppCompatActivity implements ItemClickListener {

    private static final String IE_HERO_NAME = "IE_HERO_NAME";

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView tvRole,tvToolbarTitle;
    private TextView tvIntelligence,tvAgility,tvStrength,tvDamage,tvMovementSpeed,tvArmor;
    private ImageView imgHero;
    private CustomExpendableTextView tvExpandableOverview,tvExpendableDetail;
    private Button btnReadMoreOverview,btnReadMoreDetail;
    private HeroSpellRVAdapter heroSpellAdapter;
    private MaterialDialog materialDialog;

    public static Intent newInstance(String heroName){
        Intent intent = new Intent(Dota2HeroApp.getContext(),AgilityHeroDetailActivity.class);
        intent.putExtra(IE_HERO_NAME,heroName);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item_container);

        configsView();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        String heroName = getIntent().getStringExtra(IE_HERO_NAME);
        final HeroVO heroVO = AgilityHeroModel.getInstance().getBasicItemByName(heroName);
        if (heroVO == null){
            throw new RuntimeException("Can't find obj"+heroName);
        }else {
            tvExpandableOverview.setText(heroVO.getHeroOverview());
            tvExpendableDetail.setText(heroVO.getHeroDetail());
            tvToolbarTitle.setText(heroVO.getHeroName());
            tvRole.setText(heroVO.getHeroRole());
            Glide.with(Dota2HeroApp.getContext()).load(heroVO.getHeroImage()).asBitmap().diskCacheStrategy(DiskCacheStrategy.RESULT).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(imgHero);
        }

        RecyclerView rvHeroSpell = (RecyclerView)findViewById(R.id.rv_hero_spell);
        rvHeroSpell.setHasFixedSize(true);
        heroSpellAdapter = new HeroSpellRVAdapter(heroVO.getHeroSpell(),this);
        rvHeroSpell.setAdapter(heroSpellAdapter);
        rvHeroSpell.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, heroVO.getShareHero());
                startActivity(Intent.createChooser(shareIntent, "Share link using"));
            }
        });

        tvIntelligence.setText(heroVO.getHeroIntellgience());
        tvAgility.setText(heroVO.getHeroAgility());
        tvStrength.setText(heroVO.getHeroStrength());
        tvDamage.setText(heroVO.getHeroDamage());
        tvMovementSpeed.setText(heroVO.getHeroMovementSpeed());
        tvArmor.setText(heroVO.getHeroArmor());


    }

    private void configsView() {

        tvIntelligence = (TextView)findViewById(R.id.tv_intelligence);
        tvAgility = (TextView)findViewById(R.id.tv_agility);
        tvStrength = (TextView)findViewById(R.id.tv_strength);
        tvDamage = (TextView)findViewById(R.id.tv_damage);
        tvMovementSpeed = (TextView)findViewById(R.id.tv_movement_speed);
        tvArmor = (TextView)findViewById(R.id.tv_armor);

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


        tvToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        tvRole = (TextView)findViewById(R.id.tv_role);
        imgHero = (ImageView)findViewById(R.id.col_img_hero);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitleEnabled(false);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view, int position) {
        HeroSpellVO heroSpell = heroSpellAdapter.getHeroSpell(position);
        materialDialog = new MaterialDialog(this)
                .setTitle(heroSpell.getSpellName())
                .setMessage(heroSpell.getSpellOverview())
                .setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDialog.dismiss();
                    }
                });

        materialDialog.show();
    }
}
