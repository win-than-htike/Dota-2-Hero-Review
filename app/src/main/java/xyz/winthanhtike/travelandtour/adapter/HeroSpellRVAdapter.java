package xyz.winthanhtike.travelandtour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.HeroSpellVO;
import xyz.winthanhtike.travelandtour.utils.ItemClickListener;
import xyz.winthanhtike.travelandtour.views.HeroSpellViewHolder;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class HeroSpellRVAdapter extends RecyclerView.Adapter<HeroSpellViewHolder> {

    private LayoutInflater inflater;
    private List<HeroSpellVO> heroSpellList;
    private ItemClickListener itemClickListener;
    int lastPosition = -1;

    public HeroSpellRVAdapter(List<HeroSpellVO> heroSpellList,ItemClickListener itemClickListener) {
        this.heroSpellList = heroSpellList;
        this.itemClickListener = itemClickListener;
        inflater = LayoutInflater.from(Dota2HeroApp.getContext());
    }

    @Override
    public HeroSpellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.spell_card_item,parent,false);
        return new HeroSpellViewHolder(v,itemClickListener);
    }

    @Override
    public void onBindViewHolder(HeroSpellViewHolder holder, int position) {
        holder.setData(heroSpellList.get(position));
        if(position >lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(Dota2HeroApp.getContext(), R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    public HeroSpellVO getHeroSpell(int position){
        return heroSpellList.get(position);
    }

    @Override
    public int getItemCount() {
        return heroSpellList.size();
    }
}
