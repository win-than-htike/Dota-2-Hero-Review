package xyz.winthanhtike.travelandtour.fragment;

import android.content.Context;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.StrengthRVAdapter;
import xyz.winthanhtike.travelandtour.data.model.StrengthHeroModel;
import xyz.winthanhtike.travelandtour.utils.ControllerHero;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class StrengthFragment extends Fragment {

    private RecyclerView rvStrengthHero;
    private StrengthRVAdapter sAdapter;
    private ControllerHero controllerHero;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sAdapter = new StrengthRVAdapter(StrengthHeroModel.getInstance().getHeroList(),controllerHero);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controllerHero = (ControllerHero) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.strength_fragment,container,false);

        rvStrengthHero = (RecyclerView)view.findViewById(R.id.rv_strength_hero);
        rvStrengthHero.setAdapter(sAdapter);
        int gridColumnSpanCount = getResources().getInteger(R.integer.hero_list_grid);
        rvStrengthHero.setLayoutManager(new GridLayoutManager(Dota2HeroApp.getContext(),gridColumnSpanCount));

        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(1000);
        animator.setRemoveDuration(1000);
        rvStrengthHero.setItemAnimator(animator);

        return view;
    }
}
