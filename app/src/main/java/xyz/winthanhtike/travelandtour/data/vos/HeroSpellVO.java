package xyz.winthanhtike.travelandtour.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class HeroSpellVO {

    @SerializedName("spell_name")
    private String spellName;
    @SerializedName("spell_image")
    private String spellImage;
    @SerializedName("spell_overview")
    private String spellOverview;

    public HeroSpellVO(String spellName, String spellImage, String spellOverview) {
        this.spellName = spellName;
        this.spellImage = spellImage;
        this.spellOverview = spellOverview;
    }

    public String getSpellName() {
        return spellName;
    }

    public String getSpellImage() {
        return spellImage;
    }

    public String getSpellOverview() {
        return spellOverview;
    }
}
