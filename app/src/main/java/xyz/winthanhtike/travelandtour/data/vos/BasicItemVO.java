package xyz.winthanhtike.travelandtour.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by winthanhtike on 7/7/16.
 */
public class BasicItemVO {

    @SerializedName("item_name")
    private String bItemName;

    @SerializedName("item_price")
    private String bItemPrice;

    @SerializedName("item_image_url")
    private String bItemImageUrl;

    @SerializedName("item_overview")
    private String bItemOverview;

    @SerializedName("item_detail")
    private String bItemDetail;

    public BasicItemVO(String bItemName,String bItemPrice, String bItemImageUrl, String bItemOverview, String bItemDetail) {
        this.bItemName = bItemName;
        this.bItemPrice = bItemPrice;
        this.bItemImageUrl = bItemImageUrl;
        this.bItemOverview = bItemOverview;
        this.bItemDetail = bItemDetail;
    }

    public String getbItemName() {
        return bItemName;
    }

    public String getbItemPrice() {
        return bItemPrice;
    }

    public String getbItemImageUrl() {
        return bItemImageUrl;
    }

    public String getbItemOverview() {
        return bItemOverview;
    }

    public String getbItemDetail() {
        return bItemDetail;
    }

}
