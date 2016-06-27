package xyz.winthanhtike.travelandtour.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.activity.IntelligenceHeroDetailActivity;
import xyz.winthanhtike.travelandtour.adapter.IntelligenceRVAdapter;
import xyz.winthanhtike.travelandtour.db.DataContract;
import xyz.winthanhtike.travelandtour.db.DataProvider;
import xyz.winthanhtike.travelandtour.model.IntelligenceHero;
import xyz.winthanhtike.travelandtour.model.IntelligenceHeroData;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class IntelligenceFragment extends Fragment {

    private RecyclerView rvIntellHero;
    private IntelligenceRVAdapter iAdapter;
    private RecyclerView.LayoutManager iLayoutManager;
    List<IntelligenceHero> intelligenceHeroList;
    DataProvider provider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intell_fragment,container,false);
        initView(view);
        return view;
    }

    public void initView(View v){

        provider = new DataProvider(Dota2HeroApp.getContext());

        rvIntellHero = (RecyclerView)v.findViewById(R.id.rv_intelligence_hero);
        rvIntellHero.setHasFixedSize(true);

        iLayoutManager = new LinearLayoutManager(Dota2HeroApp.getContext());
        rvIntellHero.setLayoutManager(iLayoutManager);

        intelligenceHeroList = new ArrayList<>();
        intelligenceHeroList = provider.getAllIntelligenceHero();

        if (intelligenceHeroList.size() <= 0){

            IntelligenceHeroData.HerosInfo(Dota2HeroApp.getContext());
            intelligenceHeroList = provider.getAllIntelligenceHero();

        }

        iAdapter = new IntelligenceRVAdapter(Dota2HeroApp.getContext(),intelligenceHeroList);
        IntelligenceRVAdapter.ItemClickListener clickListener = new IntelligenceRVAdapter.ItemClickListener() {
            @Override
            public void itemClick(View v, int position) {

                IntelligenceHero intelligenceHero = iAdapter.selectedPosition(position);
                Intent intent = new Intent(getContext(), IntelligenceHeroDetailActivity.class);
                intent.putExtra(DataContract.IntelligenceTable.TABLE_NAME,intelligenceHero);
                startActivity(intent);

            }
        };

        iAdapter.setItemClickListener(clickListener);
        rvIntellHero.setAdapter(iAdapter);

    }

    @Override
    public void onStop() {
        provider.close();
        super.onStop();
    }
}
