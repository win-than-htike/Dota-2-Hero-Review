package xyz.winthanhtike.travelandtour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.RecipeRVAdapter;
import xyz.winthanhtike.travelandtour.data.model.BasicItemModel;
import xyz.winthanhtike.travelandtour.data.model.UpgradeItemModel;
import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;
import xyz.winthanhtike.travelandtour.data.vos.UpgradeItemVO;

public class UpgradeItemDetailActivity extends AppCompatActivity {



    private static final String IE_ITEM_TITLE = "IE_ITEM_TITLE";

    private TextView tvItemPrice;
    private TextView tvItemOverview;
    private TextView tvItemDetail;
    private ImageView ivItemPhoto;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView rvRecipe;
    private RecipeRVAdapter recipeAdapter;

    public static Intent newInstance(String itemName){
        Intent i = new Intent(Dota2HeroApp.getContext(),UpgradeItemDetailActivity.class);
        i.putExtra(IE_ITEM_TITLE,itemName);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_item_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvItemPrice = (TextView)findViewById(R.id.tv_upgrade_item_price);
        tvItemOverview = (TextView)findViewById(R.id.tv_upgrade_item_overview);
        tvItemDetail = (TextView)findViewById(R.id.tv_upgrade_item_detail);
        ivItemPhoto = (ImageView)findViewById(R.id.iv_upgrade_item_collapse_image);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing__upgrade_item_detail_toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String itemName = getIntent().getStringExtra(IE_ITEM_TITLE);
        UpgradeItemVO upgradeItem = UpgradeItemModel.getInstance().getBasicItemByName(itemName);
        if (upgradeItem == null){
            throw new RuntimeException("Can't find Event obj with the title : "+itemName);
        }else {
            collapsingToolbarLayout.setTitle(upgradeItem.getItemName());
            tvItemPrice.setText(upgradeItem.getItemPrice());
            tvItemOverview.setText(upgradeItem.getItemOverview());
            tvItemDetail.setText(upgradeItem.getItemDetail());

            Picasso.with(ivItemPhoto.getContext()).load(upgradeItem.getItemImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(ivItemPhoto);

        }

        rvRecipe = (RecyclerView)findViewById(R.id.rv_recipe);
        recipeAdapter = new RecipeRVAdapter(upgradeItem.getRecipeVO());
        rvRecipe.setAdapter(recipeAdapter);
        rvRecipe.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
