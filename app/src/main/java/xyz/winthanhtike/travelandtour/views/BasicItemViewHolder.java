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

/**
 * Created by winthanhtike on 7/7/16.
 */
public class BasicItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvItemName;
    private ImageView ivItemImage;
    private BasicItemVO basicItem;
    private BasicItemFragment.ControllerBasicItem mControllerBasicItem;

    public BasicItemViewHolder(View itemView, BasicItemFragment.ControllerBasicItem controllerBasicItem) {
        super(itemView);

        tvItemName = (TextView)itemView.findViewById(R.id.tv_item_name);
        ivItemImage = (ImageView)itemView.findViewById(R.id.iv_item_image);
        itemView.setOnClickListener(this);
        mControllerBasicItem = controllerBasicItem;

    }

    public void setData(BasicItemVO basicItemVO){
        this.basicItem = basicItemVO;

        tvItemName.setText(basicItemVO.getbItemName());
        Picasso.with(Dota2HeroApp.getContext()).load(basicItemVO.getbItemImageUrl()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivItemImage);
    }

    @Override
    public void onClick(View v) {
        mControllerBasicItem.onTapBasicItem(basicItem,ivItemImage);
    }
}
