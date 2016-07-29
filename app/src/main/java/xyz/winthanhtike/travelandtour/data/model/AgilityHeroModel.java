package xyz.winthanhtike.travelandtour.data.model;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import xyz.winthanhtike.travelandtour.data.vos.HeroVO;
import xyz.winthanhtike.travelandtour.utils.CommonInstances;
import xyz.winthanhtike.travelandtour.utils.JsonUtils;

/**
 * Created by winthanhtike on 7/10/16.
 */
public class AgilityHeroModel {

    private static final String AGILITY_HERO_LIST = "agility_hero.json";

    private static AgilityHeroModel objInstance;

    private List<HeroVO> agilityHeroList;

    public static AgilityHeroModel getInstance(){
        if (objInstance == null){
            objInstance = new AgilityHeroModel();
        }
        return objInstance;
    }

    private AgilityHeroModel(){
        agilityHeroList = initializeStrengthHeroList();
    }

    public List<HeroVO> getHeroList() {
        Collections.sort(agilityHeroList, new Comparator<HeroVO>() {
            @Override
            public int compare(HeroVO lhs, HeroVO rhs) {
                return lhs.getHeroName().compareToIgnoreCase(rhs.getHeroName());
            }
        });

        return agilityHeroList;
    }

    private List<HeroVO> initializeStrengthHeroList(){

        List<HeroVO> agilityHeroList = new ArrayList<>();

        try {
            String basicItem = JsonUtils.getInstance().loadBasicItemData(AGILITY_HERO_LIST);
            Type listType = new TypeToken<List<HeroVO>>(){
            }.getType();
            agilityHeroList = CommonInstances.getGsonInstance().fromJson(basicItem, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return agilityHeroList;
    }

    public HeroVO getBasicItemByName(String heroName){

        for (HeroVO heroList : agilityHeroList){
            if (heroList.getHeroName().equals(heroName)){
                return heroList;
            }
        }
        return null;
    }

}
