package xyz.winthanhtike.travelandtour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.fragment.HomeFragment;
import xyz.winthanhtike.travelandtour.fragment.IntelligenceFragment;
import xyz.winthanhtike.travelandtour.fragment.StrengthFragment;

/**
 * Created by winthanhtike on 6/11/16.
 */
public class IntelligenceRVAdapter extends RecyclerView.Adapter<IntelligenceRVAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<HeroVO> intelligenceHeros;
    private HomeFragment.ControllerHero controllerHero;
    int lastPosition = -1;

    public IntelligenceRVAdapter(List<HeroVO> intelligenceHeros, HomeFragment.ControllerHero controllerHero) {
        inflater = LayoutInflater.from(Dota2HeroApp.getContext());
        this.intelligenceHeros = intelligenceHeros;
        this.controllerHero = controllerHero;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view,controllerHero);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(intelligenceHeros.get(position));
        if(position >lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(Dota2HeroApp.getContext(), R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }

    }

    @Override
    public int getItemCount() {
        return intelligenceHeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvHeroName;
        private ImageView imgHero;
        private HeroVO heroVO;
        private HomeFragment.ControllerHero controllerHero;

        public ViewHolder(View itemView, HomeFragment.ControllerHero controllerHero) {
            super(itemView);

            tvHeroName = (TextView)itemView.findViewById(R.id.tv_hero_name);
            imgHero = (ImageView)itemView.findViewById(R.id.img_hero);
            itemView.setOnClickListener(this);
            this.controllerHero = controllerHero;

        }

        public void setData(HeroVO heroVO){

            this.heroVO = heroVO;
            tvHeroName.setText(heroVO.getHeroName());
            Picasso.with(Dota2HeroApp.getContext()).load(heroVO.getHeroImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(imgHero);
        }

        @Override
        public void onClick(View v) {
            controllerHero.onTapIntellHero(heroVO,imgHero);
        }
    }
}
