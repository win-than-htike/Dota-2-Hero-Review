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
import xyz.winthanhtike.travelandtour.data.vos.UpgradeItemVO;
import xyz.winthanhtike.travelandtour.fragment.BasicItemFragment;
import xyz.winthanhtike.travelandtour.fragment.ItemFragment;
import xyz.winthanhtike.travelandtour.views.UpgradeItemViewHolder;

/**
 * Created by winthanhtike on 7/11/16.
 */
public class UpgradeItemRVAdapter extends RecyclerView.Adapter<UpgradeItemViewHolder> {

    private LayoutInflater inflater;
    private List<UpgradeItemVO> upgradeItemList;
    private ItemFragment.ControllerItem controllerItem;
    int lastPosition = -1;

    public UpgradeItemRVAdapter(List<UpgradeItemVO> upgradeItemList, ItemFragment.ControllerItem controllerItem) {
        inflater = LayoutInflater.from(Dota2HeroApp.getContext());
        this.upgradeItemList = upgradeItemList;
        this.controllerItem = controllerItem;
    }

    @Override
    public UpgradeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bacsic_item_card,parent,false);
        return new UpgradeItemViewHolder(view,controllerItem);
    }

    @Override
    public void onBindViewHolder(UpgradeItemViewHolder holder, int position) {
        holder.setData(upgradeItemList.get(position));
        if(position >lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(Dota2HeroApp.getContext(), R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return upgradeItemList.size();
    }
}
