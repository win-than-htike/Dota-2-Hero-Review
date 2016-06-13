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

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.activity.AgilityHeroDetailActivity;
import xyz.winthanhtike.travelandtour.adapter.AgilityRVAdapter;
import xyz.winthanhtike.travelandtour.db.DataContract;
import xyz.winthanhtike.travelandtour.db.DataProvider;
import xyz.winthanhtike.travelandtour.model.AgilityHero;
import xyz.winthanhtike.travelandtour.model.AgilityHeroData;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class AgilityFragment extends Fragment {

    private RecyclerView rvAgilityHero;
    private RecyclerView.LayoutManager aLayoutManager;
    private AgilityRVAdapter aAdapter;
    List<AgilityHero> agilityHeroList;

    public AgilityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.agility_fragment,container,false);
        configView(view);
        return view;
    }

    public void configView(View v){

        DataProvider db = new DataProvider(getContext());

        rvAgilityHero = (RecyclerView)v.findViewById(R.id.rv_agility_hero);
        rvAgilityHero.setHasFixedSize(true);

        aLayoutManager = new LinearLayoutManager(getContext());
        rvAgilityHero.setLayoutManager(aLayoutManager);

        agilityHeroList = new ArrayList<>();
        agilityHeroList = db.getAllAgilityHero();

        if (agilityHeroList.size() <= 0){

            AgilityHeroData.HerosInfo(getContext());
            agilityHeroList = db.getAllAgilityHero();

        }

        aAdapter = new AgilityRVAdapter(getContext(),agilityHeroList);
        AgilityRVAdapter.OnItemClickListener itemClickListener = new AgilityRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                AgilityHero agilityHero = aAdapter.selectAHero(position);
                Intent intent = new Intent(getContext(), AgilityHeroDetailActivity.class);
                intent.putExtra(DataContract.AgilityTable.TABLE_NAME,agilityHero);
                startActivity(intent);

            }
        };

        aAdapter.setOnItemClickListener(itemClickListener);
        rvAgilityHero.setAdapter(aAdapter);


    }
}