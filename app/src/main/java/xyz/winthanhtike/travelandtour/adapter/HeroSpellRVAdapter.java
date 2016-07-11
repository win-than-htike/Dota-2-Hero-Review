package xyz.winthanhtike.travelandtour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.HeroSpellVO;
import xyz.winthanhtike.travelandtour.views.HeroSpellViewHolder;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class HeroSpellRVAdapter extends RecyclerView.Adapter<HeroSpellViewHolder> {

    private LayoutInflater inflater;
    private List<HeroSpellVO> heroSpellList;

    public HeroSpellRVAdapter(List<HeroSpellVO> heroSpellList) {
        this.heroSpellList = heroSpellList;
        inflater = LayoutInflater.from(Dota2HeroApp.getContext());
    }

    @Override
    public HeroSpellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.spell_card_item,parent,false);
        return new HeroSpellViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HeroSpellViewHolder holder, int position) {
        holder.setData(heroSpellList.get(position));
    }

    @Override
    public int getItemCount() {
        return heroSpellList.size();
    }
}
