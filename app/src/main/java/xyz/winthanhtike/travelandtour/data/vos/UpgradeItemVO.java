package xyz.winthanhtike.travelandtour.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by winthanhtike on 7/11/16.
 */
public class UpgradeItemVO {

    @SerializedName("item_name")
    private String itemName;
    @SerializedName("item_price")
    private String itemPrice;
    @SerializedName("item_image_url")
    private String itemImage;
    @SerializedName("item_overview")
    private String itemOverview;
    @SerializedName("item_detail")
    private String itemDetail;
    @SerializedName("recipe")
    private ArrayList<RecipeVO> recipeVO;

    public UpgradeItemVO(String itemName, String itemPrice, String itemImage, String itemOverview, String itemDetail, ArrayList<RecipeVO> recipeVO) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemOverview = itemOverview;
        this.itemDetail = itemDetail;
        this.recipeVO = recipeVO;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemImage() {
        return itemImage;
    }

    public String getItemOverview() {
        return itemOverview;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public ArrayList<RecipeVO> getRecipeVO() {
        return recipeVO;
    }
}
