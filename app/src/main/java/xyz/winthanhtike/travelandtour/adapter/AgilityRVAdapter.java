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
import xyz.winthanhtike.travelandtour.fragment.AgilityFragment;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class AgilityRVAdapter extends RecyclerView.Adapter<AgilityRVAdapter.ViewHolder>{

    private List<HeroVO> agilityHeroList;
    private AgilityFragment.ControllerAgilityHero controllerAgilityHero;

    public AgilityRVAdapter(List<HeroVO> agilityHeroList, AgilityFragment.ControllerAgilityHero controllerAgilityHero) {
        this.agilityHeroList = agilityHeroList;
        this.controllerAgilityHero = controllerAgilityHero;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Dota2HeroApp.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(v,controllerAgilityHero);
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
        private AgilityFragment.ControllerAgilityHero controllerAgilityHero;
        private HeroVO heroVO;

        public ViewHolder(View itemView, AgilityFragment.ControllerAgilityHero controllerAgilityHero) {
            super(itemView);

            tvAHeroName = (TextView)itemView.findViewById(R.id.tv_hero_name);
            imgAHero = (ImageView)itemView.findViewById(R.id.img_hero);
            itemView.setOnClickListener(this);
            this.controllerAgilityHero = controllerAgilityHero;

        }

        public void setData(HeroVO heroVO){
            this.heroVO = heroVO;
            tvAHeroName.setText(heroVO.getHeroName());
            Picasso.with(Dota2HeroApp.getContext()).load(heroVO.getHeroImage()).error(R.mipmap.ic_launcher).into(imgAHero);
        }

        @Override
        public void onClick(View v) {
            controllerAgilityHero.onTapAgilityHero(heroVO,imgAHero);
        }
    }
}
