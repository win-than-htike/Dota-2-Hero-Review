package xyz.winthanhtike.travelandtour.data.model;

import java.io.Serializable;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class AgilityHero implements Serializable {

    private String aHeroName;
    private String aHeroImageUrl;
    private String aHeroOverview;
    private String aHeroDetail;
    private String aHeroRole;

    public AgilityHero() {}

    public AgilityHero(String aHeroName, String aHeroImageUrl, String aHeroOverview, String aHeroDetail,String aHeroRole) {
        this.aHeroName = aHeroName;
        this.aHeroImageUrl = aHeroImageUrl;
        this.aHeroOverview = aHeroOverview;
        this.aHeroDetail = aHeroDetail;
        this.aHeroRole = aHeroRole;
    }

    public String getaHeroRole() {
        return aHeroRole;
    }

    public void setaHeroRole(String aHeroRole) {
        this.aHeroRole = aHeroRole;
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
