package xyz.winthanhtike.travelandtour.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.data.vos.RecipeVO;

/**
 * Created by winthanhtike on 7/11/16.
 */
public class RecipeViewHolder extends RecyclerView.ViewHolder{

    private TextView tvRecipeName;
    private ImageView ivRecipeImage;
    private RecipeVO recipe;

    public RecipeViewHolder(View itemView) {
        super(itemView);

        tvRecipeName = (TextView)itemView.findViewById(R.id.tv_recipe_name);
        ivRecipeImage = (ImageView)itemView.findViewById(R.id.iv_recipe_image);

    }

    public void setData(RecipeVO recipe){
        this.recipe = recipe;
        tvRecipeName.setText(recipe.getRecipeName());
        Picasso.with(Dota2HeroApp.getContext()).load(recipe.getRecipeImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(ivRecipeImage);
    }

}
