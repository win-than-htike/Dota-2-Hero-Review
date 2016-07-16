package xyz.winthanhtike.travelandtour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.RecipeVO;
import xyz.winthanhtike.travelandtour.views.RecipeViewHolder;

/**
 * Created by winthanhtike on 7/11/16.
 */
public class RecipeRVAdapter extends RecyclerView.Adapter<RecipeViewHolder>{

    private LayoutInflater inflater;
    private List<RecipeVO> recipeList;
    int lastPosition = -1;

    public RecipeRVAdapter(List<RecipeVO> recipeList) {
        this.recipeList = recipeList;
        inflater = LayoutInflater.from(Dota2HeroApp.getContext());
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recipe_card_item,parent,false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        holder.setData(recipeList.get(position));
        if(position >lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(Dota2HeroApp.getContext(), R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
