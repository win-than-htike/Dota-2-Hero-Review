package xyz.winthanhtike.travelandtour.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;
import xyz.winthanhtike.travelandtour.fragment.BasicItemFragment;
import xyz.winthanhtike.travelandtour.fragment.ItemFragment;

/**
 * Created by winthanhtike on 7/7/16.
 */
public class BasicItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvItemName;
    private ImageView ivItemImage;
    private BasicItemVO basicItem;
    private ItemFragment.ControllerItem controllerItem;

    public BasicItemViewHolder(View itemView, ItemFragment.ControllerItem controllerItem) {
        super(itemView);

        tvItemName = (TextView)itemView.findViewById(R.id.tv_item_name);
        ivItemImage = (ImageView)itemView.findViewById(R.id.iv_item_image);
        itemView.setOnClickListener(this);
        this.controllerItem = controllerItem;

    }

    public void setData(BasicItemVO basicItemVO){
        this.basicItem = basicItemVO;

        tvItemName.setText(basicItemVO.getbItemName());
        Picasso.with(Dota2HeroApp.getContext()).load(basicItemVO.getbItemImageUrl()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(ivItemImage);
    }

    @Override
    public void onClick(View v) {
        controllerItem.onTapBasicItem(basicItem,ivItemImage);
    }
}
