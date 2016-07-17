package xyz.winthanhtike.travelandtour.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class HeroVO {

    @SerializedName("share_hero")
    private String shareHero;
    @SerializedName("hero_intellgience")
    private String heroIntellgience;
    @SerializedName("hero_agility")
    private String heroAgility;
    @SerializedName("hero_strength")
    private String heroStrength;
    @SerializedName("hero_damage")
    private String heroDamage;
    @SerializedName("hero_movement_speed")
    private String heroMovementSpeed;
    @SerializedName("hero_armor")
    private String heroArmor;
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

    public HeroVO(String shareHero, String heroIntellgience, String heroAgility, String heroStrength, String heroDamage, String heroMovementSpeed, String heroArmor, String heroName, String heroImage, String heroRole, String heroDetail, String heroOverview, ArrayList<HeroSpellVO> heroSpell) {
        this.shareHero = shareHero;
        this.heroIntellgience = heroIntellgience;
        this.heroAgility = heroAgility;
        this.heroStrength = heroStrength;
        this.heroDamage = heroDamage;
        this.heroMovementSpeed = heroMovementSpeed;
        this.heroArmor = heroArmor;
        this.heroName = heroName;
        this.heroImage = heroImage;
        this.heroRole = heroRole;
        this.heroDetail = heroDetail;
        this.heroOverview = heroOverview;
        this.heroSpell = heroSpell;
    }

    public String getHeroIntellgience() {
        return heroIntellgience;
    }

    public String getHeroAgility() {
        return heroAgility;
    }

    public String getHeroStrength() {
        return heroStrength;
    }

    public String getHeroDamage() {
        return heroDamage;
    }

    public String getHeroMovementSpeed() {
        return heroMovementSpeed;
    }

    public String getHeroArmor() {
        return heroArmor;
    }

    public String getShareHero() {return shareHero;}

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
