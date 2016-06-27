package xyz.winthanhtike.travelandtour.model;

import java.io.Serializable;

/**
 * Created by winthanhtike on 6/11/16.
 */
public class IntelligenceHero implements Serializable{

    private String iHeroName;
    private String iHeroImageUrl;
    private String iHeroOverview;
    private String iHeroDetail;
    private String iHeroRole;

    public IntelligenceHero(){}

    public IntelligenceHero(String iHeroName, String iHeroImageUrl, String iHeroOverview, String iHeroDetail) {
        this.iHeroName = iHeroName;
        this.iHeroImageUrl = iHeroImageUrl;
        this.iHeroOverview = iHeroOverview;
        this.iHeroDetail = iHeroDetail;
    }

    public String getiHeroRole() {
        return iHeroRole;
    }

    public void setiHeroRole(String iHeroRole) {
        this.iHeroRole = iHeroRole;
    }

    public String getiHeroName() {
        return iHeroName;
    }

    public void setiHeroName(String iHeroName) {
        this.iHeroName = iHeroName;
    }

    public String getiHeroImageUrl() {
        return iHeroImageUrl;
    }

    public void setiHeroImageUrl(String iHeroImageUrl) {
        this.iHeroImageUrl = iHeroImageUrl;
    }

    public String getiHeroOverview() {
        return iHeroOverview;
    }

    public void setiHeroOverview(String iHeroOverview) {
        this.iHeroOverview = iHeroOverview;
    }

    public String getiHeroDetail() {
        return iHeroDetail;
    }

    public void setiHeroDetail(String iHeroDetail) {
        this.iHeroDetail = iHeroDetail;
    }
}
