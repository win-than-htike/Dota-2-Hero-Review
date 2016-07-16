package xyz.winthanhtike.travelandtour.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;
import xyz.winthanhtike.travelandtour.fragment.BasicItemFragment;
import xyz.winthanhtike.travelandtour.fragment.ItemFragment;
import xyz.winthanhtike.travelandtour.views.BasicItemViewHolder;

/**
 * Created by winthanhtike on 7/3/16.
 */
public class BasicItemRVAdapter extends RecyclerView.Adapter<BasicItemViewHolder>{

    private LayoutInflater inflater;
    private List<BasicItemVO> basicItemList;
    private ItemFragment.ControllerItem controllerItem;
    int lastPosition = -1;

    public BasicItemRVAdapter(List<BasicItemVO> basicItemList, ItemFragment.ControllerItem controllerItem) {
        inflater = LayoutInflater.from(Dota2HeroApp.getContext());
        this.basicItemList = basicItemList;
        this.controllerItem = controllerItem;
    }

    @Override
    public BasicItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bacsic_item_card,parent,false);
        return new BasicItemViewHolder(view,controllerItem);
    }

    @Override
    public void onBindViewHolder(BasicItemViewHolder holder, int position) {
        holder.setData(basicItemList.get(position));

        if(position >lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(Dota2HeroApp.getContext(), R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return basicItemList.size();
    }
}
