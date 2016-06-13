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
import xyz.winthanhtike.travelandtour.model.AgilityHero;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class AgilityRVAdapter extends RecyclerView.Adapter<AgilityRVAdapter.ViewHolder>{

    private Context context;
    private List<AgilityHero> agilityHeroList;
    OnItemClickListener itemClickListener;

    public AgilityRVAdapter(Context context, List<AgilityHero> agilityHeroList) {
        this.context = context;
        this.agilityHeroList = agilityHeroList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvAHeroName.setText(agilityHeroList.get(position).getaHeroName());
        Picasso.with(context).load(agilityHeroList.get(position).getaHeroImageUrl()).error(R.mipmap.ic_launcher).into(holder.imgAHero);

    }

    @Override
    public int getItemCount() {
        return agilityHeroList.size();
    }

    public AgilityHero selectAHero(int position){

        return agilityHeroList.get(position);

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvAHeroName;
        private ImageView imgAHero;

        public ViewHolder(View itemView) {
            super(itemView);

            tvAHeroName = (TextView)itemView.findViewById(R.id.tv_hero_name);
            imgAHero = (ImageView)itemView.findViewById(R.id.img_hero);
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
