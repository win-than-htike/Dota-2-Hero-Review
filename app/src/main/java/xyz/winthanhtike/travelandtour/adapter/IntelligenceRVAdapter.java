package xyz.winthanhtike.travelandtour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.fragment.IntelligenceFragment;
import xyz.winthanhtike.travelandtour.fragment.StrengthFragment;

/**
 * Created by winthanhtike on 6/11/16.
 */
public class IntelligenceRVAdapter extends RecyclerView.Adapter<IntelligenceRVAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<HeroVO> intelligenceHeros;
    private IntelligenceFragment.ControllerIntelligenceHero heroController;

    public IntelligenceRVAdapter(List<HeroVO> intelligenceHeros, IntelligenceFragment.ControllerIntelligenceHero heroController) {
        inflater = LayoutInflater.from(Dota2HeroApp.getContext());
        this.intelligenceHeros = intelligenceHeros;
        this.heroController = heroController;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view,heroController);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(intelligenceHeros.get(position));

    }

    @Override
    public int getItemCount() {
        return intelligenceHeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvHeroName;
        private ImageView imgHero;
        private HeroVO heroVO;
        private IntelligenceFragment.ControllerIntelligenceHero heroController;

        public ViewHolder(View itemView, IntelligenceFragment.ControllerIntelligenceHero heroController) {
            super(itemView);

            tvHeroName = (TextView)itemView.findViewById(R.id.tv_hero_name);
            imgHero = (ImageView)itemView.findViewById(R.id.img_hero);
            itemView.setOnClickListener(this);
            this.heroController = heroController;

        }

        public void setData(HeroVO heroVO){

            this.heroVO = heroVO;
            tvHeroName.setText(heroVO.getHeroName());
            Picasso.with(Dota2HeroApp.getContext()).load(heroVO.getHeroImage()).error(R.mipmap.ic_launcher).into(imgHero);
        }

        @Override
        public void onClick(View v) {
            heroController.onTapIntellHero(heroVO,imgHero);
        }
    }
}
