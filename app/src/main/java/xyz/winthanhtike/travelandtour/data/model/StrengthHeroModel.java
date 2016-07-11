package xyz.winthanhtike.travelandtour.data.model;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.utils.CommonInstances;
import xyz.winthanhtike.travelandtour.utils.JsonUtils;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class StrengthHeroModel {

    private static final String STRENGTH_HERO_LIST = "strength_hero.json";

    private static StrengthHeroModel objInstance;

    private List<HeroVO> strengthHeroList;

    public static StrengthHeroModel getInstance(){
        if (objInstance == null){
            objInstance = new StrengthHeroModel();
        }
        return objInstance;
    }

    private StrengthHeroModel(){
        strengthHeroList = initializeStrengthHeroList();
    }

    public List<HeroVO> getStrengthHeroList() {
        return strengthHeroList;
    }

    private List<HeroVO> initializeStrengthHeroList(){

        List<HeroVO> strengthHeroList = new ArrayList<>();

        try {
            String basicItem = JsonUtils.getInstance().loadBasicItemData(STRENGTH_HERO_LIST);
            Type listType = new TypeToken<List<HeroVO>>(){
            }.getType();
            strengthHeroList = CommonInstances.getGsonInstance().fromJson(basicItem, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strengthHeroList;
    }

    public HeroVO getBasicItemByName(String heroName){

        for (HeroVO heroList : strengthHeroList){
            if (heroList.getHeroName().equals(heroName)){
                return heroList;
            }
        }
        return null;
    }

}
