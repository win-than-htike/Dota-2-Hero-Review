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
import xyz.winthanhtike.travelandtour.model.IntelligenceHero;

/**
 * Created by winthanhtike on 6/11/16.
 */
public class IntelligenceRVAdapter extends RecyclerView.Adapter<IntelligenceRVAdapter.ViewHolder> {

    private Context context;
    private List<IntelligenceHero> intelligenceHeros;
    ItemClickListener itemClickListener;

    public IntelligenceRVAdapter(Context context, List<IntelligenceHero> intelligenceHeros) {
        this.context = context;
        this.intelligenceHeros = intelligenceHeros;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvHeroName.setText(intelligenceHeros.get(position).getiHeroName());
        Picasso.with(context).load(intelligenceHeros.get(position).getiHeroImageUrl()).error(R.mipmap.ic_launcher).into(holder.imgHero);

    }

    @Override
    public int getItemCount() {
        return intelligenceHeros.size();
    }

    public IntelligenceHero selectedPosition(int position){

        return intelligenceHeros.get(position);

    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
         void itemClick(View v,int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvHeroName;
        private ImageView imgHero;

        public ViewHolder(View itemView) {
            super(itemView);

            tvHeroName = (TextView)itemView.findViewById(R.id.tv_hero_name);
            imgHero = (ImageView)itemView.findViewById(R.id.img_hero);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (itemClickListener != null){

                itemClickListener.itemClick(v,getAdapterPosition());

            }

        }
    }
}
