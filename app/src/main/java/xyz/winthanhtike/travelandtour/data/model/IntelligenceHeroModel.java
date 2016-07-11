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
 * Created by winthanhtike on 7/11/16.
 */
public class IntelligenceHeroModel {

    private static final String INTELLIENCE_HERO_LIST = "intelligence_hero.json";

    private static IntelligenceHeroModel objInstance;

    private List<HeroVO> heroList;

    public static IntelligenceHeroModel getInstance(){
        if (objInstance == null){
            objInstance = new IntelligenceHeroModel();
        }
        return objInstance;
    }

    private IntelligenceHeroModel(){
        heroList = initializeHeroList();
    }

    public List<HeroVO> getStrengthHeroList() {
        return heroList;
    }

    private List<HeroVO> initializeHeroList(){

        List<HeroVO> mHeroList = new ArrayList<>();

        try {
            String basicItem = JsonUtils.getInstance().loadBasicItemData(INTELLIENCE_HERO_LIST);
            Type listType = new TypeToken<List<HeroVO>>(){
            }.getType();
            mHeroList = CommonInstances.getGsonInstance().fromJson(basicItem, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mHeroList;
    }

    public HeroVO getBasicItemByName(String heroName){

        for (HeroVO mHeroList : heroList){
            if (mHeroList.getHeroName().equals(heroName)){
                return mHeroList;
            }
        }
        return null;
    }

}
