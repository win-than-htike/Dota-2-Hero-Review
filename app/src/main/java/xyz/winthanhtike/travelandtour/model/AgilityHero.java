package xyz.winthanhtike.travelandtour.model;

import java.io.Serializable;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class AgilityHero implements Serializable {

    private String aHeroName;
    private String aHeroImageUrl;
    private String aHeroOverview;
    private String aHeroDetail;

    public AgilityHero() {}

    public AgilityHero(String aHeroName, String aHeroImageUrl, String aHeroOverview, String aHeroDetail) {
        this.aHeroName = aHeroName;
        this.aHeroImageUrl = aHeroImageUrl;
        this.aHeroOverview = aHeroOverview;
        this.aHeroDetail = aHeroDetail;
    }

    public String getaHeroName() {
        return aHeroName;
    }

    public void setaHeroName(String aHeroName) {
        this.aHeroName = aHeroName;
    }

    public String getaHeroImageUrl() {
        return aHeroImageUrl;
    }

    public void setaHeroImageUrl(String aHeroImageUrl) {
        this.aHeroImageUrl = aHeroImageUrl;
    }

    public String getaHeroOverview() {
        return aHeroOverview;
    }

    public void setaHeroOverview(String aHeroOverview) {
        this.aHeroOverview = aHeroOverview;
    }

    public String getaHeroDetail() {
        return aHeroDetail;
    }

    public void setaHeroDetail(String aHeroDetail) {
        this.aHeroDetail = aHeroDetail;
    }
}
