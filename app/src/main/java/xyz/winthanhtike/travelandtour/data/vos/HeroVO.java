package xyz.winthanhtike.travelandtour.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class HeroVO {

    @SerializedName("hero_name")
    private String heroName;
    @SerializedName("hero_image")
    private String heroImage;
    @SerializedName("hero_role")
    private String heroRole;
    @SerializedName("hero_detail")
    private String heroDetail;
    @SerializedName("hero_overview")
    private String heroOverview;
    @SerializedName("hero_spell")
    private ArrayList<HeroSpellVO> heroSpell;

    public HeroVO(String heroName, String heroImage, String heroRole, String heroDetail, String heroOverview, ArrayList<HeroSpellVO> heroSpell) {
        this.heroName = heroName;
        this.heroImage = heroImage;
        this.heroRole = heroRole;
        this.heroDetail = heroDetail;
        this.heroOverview = heroOverview;
        this.heroSpell = heroSpell;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public String getHeroRole() {
        return heroRole;
    }

    public String getHeroDetail() {
        return heroDetail;
    }

    public String getHeroOverview() {
        return heroOverview;
    }

    public ArrayList<HeroSpellVO> getHeroSpell() {
        return heroSpell;
    }
}
