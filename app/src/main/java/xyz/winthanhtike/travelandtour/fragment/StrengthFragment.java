package xyz.winthanhtike.travelandtour.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.activity.StrengthHeroDetailActivity;
import xyz.winthanhtike.travelandtour.adapter.StrengthRVAdapter;
import xyz.winthanhtike.travelandtour.db.DataContract;
import xyz.winthanhtike.travelandtour.db.DataProvider;
import xyz.winthanhtike.travelandtour.model.StrengthHeroData;
import xyz.winthanhtike.travelandtour.model.StrengthHero;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class StrengthFragment extends Fragment {

    private RecyclerView rvStrengthHero;
    private StrengthRVAdapter sAdapter;
    private RecyclerView.LayoutManager sLayoutManager;
    List<StrengthHero> strengthHeroList;
    DataProvider db;

    public StrengthFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.strength_fragment,container,false);
            initView(view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initView(View v){

        db = new DataProvider(getContext());

        rvStrengthHero = (RecyclerView)v.findViewById(R.id.rv_strength_hero);
        rvStrengthHero.setHasFixedSize(true);

        sLayoutManager = new LinearLayoutManager(Dota2HeroApp.getContext());
        rvStrengthHero.setLayoutManager(sLayoutManager);

        strengthHeroList = new ArrayList<>();
        strengthHeroList = db.getAllStrengthHero();

        if (strengthHeroList.size() <= 0){

            StrengthHeroData.HerosInfo(getContext());
            strengthHeroList = db.getAllStrengthHero();

        }

        sAdapter = new StrengthRVAdapter(strengthHeroList,Dota2HeroApp.getContext());
        StrengthRVAdapter.OnItemClickListener itemClickListener = new StrengthRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                StrengthHero strengthHero = sAdapter.selectCurry(position);
                Intent i = new Intent(Dota2HeroApp.getContext(),StrengthHeroDetailActivity.class);
                i.putExtra(DataContract.StrengthTable.TABLE_NAME,strengthHero);
                startActivity(i);

            }
        };

        sAdapter.setOnItemClickListener(itemClickListener);
        rvStrengthHero.setAdapter(sAdapter);

    }

    @Override
    public void onStop() {
        db.close();
        super.onStop();
    }
}
