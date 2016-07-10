package xyz.winthanhtike.travelandtour.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.model.StrengthHero;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class StrengthRVAdapter extends RecyclerView.Adapter<StrengthRVAdapter.ViewHolder> {

    private List<StrengthHero> strengthHeroList;
    private Context context;
    OnItemClickListener itemClickListener;

    public StrengthRVAdapter(List<StrengthHero> strengthHeroList, Context context) {
        this.strengthHeroList = strengthHeroList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvHeroName.setText(strengthHeroList.get(position).getSheroName());
        Picasso.with(context).load(strengthHeroList.get(position).getSheroImageUrl()).error(R.mipmap.ic_launcher).into(holder.imgHero);

    }

    public StrengthHero selectCurry(int position){

        return strengthHeroList.get(position);

    }

    @Override
    public int getItemCount() {
        return strengthHeroList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvHeroName;
        private ImageView imgHero;

        public ViewHolder(View itemView) {
            super(itemView);

            tvHeroName = (TextView)itemView.findViewById(R.id.tv_hero_name);
            imgHero = (ImageView) itemView.findViewById(R.id.img_hero);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (itemClickListener != null){
                itemClickListener.onItemClick(v,getAdapterPosition());
            }

        }
    }
}
