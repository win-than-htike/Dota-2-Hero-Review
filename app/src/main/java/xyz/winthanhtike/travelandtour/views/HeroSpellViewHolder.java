package xyz.winthanhtike.travelandtour.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.HeroSpellVO;
import xyz.winthanhtike.travelandtour.utils.ItemClickListener;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class HeroSpellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvSpellName;
    private TextView tvSpellOverview;
    private ImageView ivSpellImage;
    private HeroSpellVO spellVO;
    private ItemClickListener itemClickListener;

    public HeroSpellViewHolder(View itemView,ItemClickListener itemClickListener) {
        super(itemView);

        tvSpellName = (TextView)itemView.findViewById(R.id.tv_spell_name);
//        tvSpellOverview = (TextView)itemView.findViewById(R.id.tv_spell_overview);
        ivSpellImage = (ImageView)itemView.findViewById(R.id.iv_spell_image);
        this.itemClickListener = itemClickListener;
        itemView.setOnClickListener(this);

    }

    public void setData(HeroSpellVO spellVO){
        this.spellVO = spellVO;
        tvSpellName.setText(spellVO.getSpellName());
//        tvSpellOverview.setText(spellVO.getSpellOverview());
        Picasso.with(Dota2HeroApp.getContext()).load(spellVO.getSpellImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(ivSpellImage);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }
}
