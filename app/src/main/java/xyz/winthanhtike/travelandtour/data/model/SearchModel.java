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
 * Created by winthanhtike on 7/31/16.
 */
public class SearchModel {

    private static final String AGILITY_HERO_LIST = "search_list.json";

    private static SearchModel objInstance;

    private List<HeroVO> searchHeroList;

    public static SearchModel getInstance(){
        if (objInstance == null){
            objInstance = new SearchModel();
        }
        return objInstance;
    }

    private SearchModel(){
        searchHeroList = initializeSearchHeroList();
    }

    public List<HeroVO> getHeroList() {
        Collections.sort(searchHeroList, new Comparator<HeroVO>() {
            @Override
            public int compare(HeroVO lhs, HeroVO rhs) {
                return lhs.getHeroName().compareToIgnoreCase(rhs.getHeroName());
            }
        });

        return searchHeroList;
    }

    private List<HeroVO> initializeSearchHeroList(){

        List<HeroVO> searchHeroList = new ArrayList<>();

        try {
            String basicItem = JsonUtils.getInstance().loadBasicItemData(AGILITY_HERO_LIST);
            Type listType = new TypeToken<List<HeroVO>>(){
            }.getType();
            searchHeroList = CommonInstances.getGsonInstance().fromJson(basicItem, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchHeroList;
    }

    public HeroVO getSearchHeroListByName(String heroName){

        for (HeroVO heroList : searchHeroList){
            if (heroList.getHeroName().equals(heroName)){
                return heroList;
            }
        }
        return null;
    }

}
