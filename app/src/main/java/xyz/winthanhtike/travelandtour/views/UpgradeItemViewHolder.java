package xyz.winthanhtike.travelandtour.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.UpgradeItemVO;
import xyz.winthanhtike.travelandtour.fragment.BasicItemFragment;
import xyz.winthanhtike.travelandtour.fragment.ItemFragment;

/**
 * Created by winthanhtike on 7/11/16.
 */
public class UpgradeItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvItemName;
    private ImageView ivItemImage;
    private UpgradeItemVO upgradeItem;
    private ItemFragment.ControllerItem controllerItem;

    public UpgradeItemViewHolder(View itemView, ItemFragment.ControllerItem controllerItem) {
        super(itemView);

        ivItemImage = (ImageView)itemView.findViewById(R.id.iv_item_image);
        tvItemName = (TextView) itemView.findViewById(R.id.tv_item_name);
        itemView.setOnClickListener(this);
        this.controllerItem = controllerItem;

    }

    public void setData(UpgradeItemVO upgradeItem){
        this.upgradeItem = upgradeItem;
        tvItemName.setText(upgradeItem.getItemName());
        Picasso.with(Dota2HeroApp.getContext()).load(upgradeItem.getItemImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(ivItemImage);
    }

    @Override
    public void onClick(View v) {
        controllerItem.onTapUpgradeItem(upgradeItem,ivItemImage);
    }
}
