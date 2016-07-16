package xyz.winthanhtike.travelandtour.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by winthanhtike on 7/11/16.
 */
public class RecipeVO{

    @SerializedName("recipe_name")
    private String recipeName;
    @SerializedName("recipe_image")
    private String recipeImage;

    public RecipeVO(String recipeName, String recipeImage) {
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeImage() {
        return recipeImage;
    }
}
