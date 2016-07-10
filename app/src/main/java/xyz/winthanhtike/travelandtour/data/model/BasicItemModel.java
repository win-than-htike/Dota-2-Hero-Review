package xyz.winthanhtike.travelandtour.data.model;

import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;
import xyz.winthanhtike.travelandtour.utils.CommonInstances;
import xyz.winthanhtike.travelandtour.utils.JsonUtils;

/**
 * Created by winthanhtike on 7/7/16.
 */
public class BasicItemModel {

    private static final String BASIC_ITEM_DATA = "basic_items.json";

    private static BasicItemModel objInstance;

    private List<BasicItemVO> basicItemList;

    public static BasicItemModel getInstance(){
        if (objInstance == null){
            objInstance = new BasicItemModel();
        }
        return objInstance;
    }

    private BasicItemModel(){
        basicItemList = initializeBasicItemList();
    }

    public List<BasicItemVO> getBasicItemList() {
        return basicItemList;
    }

    private List<BasicItemVO> initializeBasicItemList(){

        List<BasicItemVO> basicItemList = new ArrayList<>();

        try {
            String basicItem = JsonUtils.getInstance().loadBasicItemData(BASIC_ITEM_DATA);
            Type listType = new TypeToken<List<BasicItemVO>>(){
            }.getType();
            basicItemList = CommonInstances.getGsonInstance().fromJson(basicItem, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return basicItemList;
    }

    public BasicItemVO getBasicItemByName(String itemName){

        for (BasicItemVO basicItem : basicItemList){
            if (basicItem.getbItemName().equals(itemName)){
                return basicItem;
            }
        }
        return null;
    }

}
