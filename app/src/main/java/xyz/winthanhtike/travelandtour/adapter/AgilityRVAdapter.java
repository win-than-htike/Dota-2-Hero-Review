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
import xyz.winthanhtike.travelandtour.utils.ControllerHero;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class AgilityRVAdapter extends RecyclerView.Adapter<AgilityRVAdapter.ViewHolder>{

    private List<HeroVO> agilityHeroList;
    private ControllerHero controllerHero;
    int lastPosition = -1;

    public AgilityRVAdapter(List<HeroVO> agilityHeroList, ControllerHero controllerHero) {
        this.agilityHeroList = agilityHeroList;
        this.controllerHero = controllerHero;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Dota2HeroApp.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(v,controllerHero);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(agilityHeroList.get(position));

    }

    @Override
    public int getItemCount() {
        return agilityHeroList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvAHeroName;
        private ImageView imgAHero;
        private ControllerHero controllerHero;
        private HeroVO heroVO;

        public ViewHolder(View itemView, ControllerHero controllerHero) {
            super(itemView);

            tvAHeroName = (TextView)itemView.findViewById(R.id.tv_hero_name);
            imgAHero = (ImageView)itemView.findViewById(R.id.img_hero);
            itemView.setOnClickListener(this);
            this.controllerHero = controllerHero;

        }

        public void setData(HeroVO heroVO){
            this.heroVO = heroVO;
            tvAHeroName.setText(heroVO.getHeroName());
            Picasso.with(Dota2HeroApp.getContext()).load(heroVO.getHeroImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(imgAHero);
        }

        @Override
        public void onClick(View v) {
            controllerHero.onTapAgilityHero(heroVO,imgAHero);
        }
    }
}
