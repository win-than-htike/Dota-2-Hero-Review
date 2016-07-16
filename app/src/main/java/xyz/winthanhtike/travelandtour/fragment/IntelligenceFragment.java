package xyz.winthanhtike.travelandtour.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.IntelligenceRVAdapter;
import xyz.winthanhtike.travelandtour.data.model.IntelligenceHeroModel;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class IntelligenceFragment extends Fragment {

    private RecyclerView rvIntellHero;
    private IntelligenceRVAdapter iAdapter;
    private HomeFragment.ControllerHero controllerHero;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iAdapter = new IntelligenceRVAdapter(IntelligenceHeroModel.getInstance().getStrengthHeroList(),controllerHero);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controllerHero = (HomeFragment.ControllerHero) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intell_fragment,container,false);

            rvIntellHero = (RecyclerView)view.findViewById(R.id.rv_intelligence_hero);
            rvIntellHero.setHasFixedSize(true);
            rvIntellHero.setAdapter(iAdapter);
            int gridColumn = getResources().getInteger(R.integer.hero_list_grid);
            rvIntellHero.setLayoutManager(new GridLayoutManager(Dota2HeroApp.getContext(),gridColumn));

        return view;
    }
}
