package xyz.winthanhtike.travelandtour.model;

import java.io.Serializable;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class StrengthHero implements Serializable {

    private String sheroName;
    private String sheroImageUrl;
    private String sheroOverview;
    private String sheroDetail;
    private String sheroRole;

    public StrengthHero(){}

    public StrengthHero(String sheroName, String sheroImageUrl, String sheroOverview, String sheroDetail) {
        this.sheroName = sheroName;
        this.sheroImageUrl = sheroImageUrl;
        this.sheroOverview = sheroOverview;
        this.sheroDetail = sheroDetail;
    }

    public String getSheroRole() {
        return sheroRole;
    }

    public void setSheroRole(String sheroRole) {
        this.sheroRole = sheroRole;
    }

    public String getSheroName() {
        return sheroName;
    }

    public void setSheroName(String sheroName) {
        this.sheroName = sheroName;
    }

    public String getSheroImageUrl() {
        return sheroImageUrl;
    }

    public void setSheroImageUrl(String sheroImageUrl) {
        this.sheroImageUrl = sheroImageUrl;
    }

    public String getSheroOverview() {
        return sheroOverview;
    }

    public void setSheroOverview(String sheroOverview) {
        this.sheroOverview = sheroOverview;
    }

    public String getSheroDetail() {
        return sheroDetail;
    }

    public void setSheroDetail(String sheroDetail) {
        this.sheroDetail = sheroDetail;
    }
}
