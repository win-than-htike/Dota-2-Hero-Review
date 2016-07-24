package xyz.winthanhtike.travelandtour.utils;

import android.widget.ImageView;

import xyz.winthanhtike.travelandtour.data.vos.HeroVO;

/**
 * Created by winthanhtike on 7/23/16.
 */
public interface ControllerHero {
    void onTapStrengthHero(HeroVO hero, ImageView ivHeroImage);
    void onTapAgilityHero(HeroVO hero,ImageView ivHeroImage);
    void onTapIntellHero(HeroVO hero,ImageView ivHeroImage);
}
