package xyz.winthanhtike.travelandtour.data.model;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;
import xyz.winthanhtike.travelandtour.data.vos.UpgradeItemVO;
import xyz.winthanhtike.travelandtour.utils.CommonInstances;
import xyz.winthanhtike.travelandtour.utils.JsonUtils;

/**
 * Created by winthanhtike on 7/11/16.
 */
public class UpgradeItemModel {

    private static final String UPGRADE_ITEM_DATA = "upgrade_item.json";

    private static UpgradeItemModel objInstance;

    private List<UpgradeItemVO> upgradeItemList;

    public static UpgradeItemModel getInstance(){
        if (objInstance == null){
            objInstance = new UpgradeItemModel();
        }
        return objInstance;
    }

    private UpgradeItemModel(){
        upgradeItemList = initializeBasicItemList();
    }

    public List<UpgradeItemVO> getUpgradeItemList() {
        return upgradeItemList;
    }

    private List<UpgradeItemVO> initializeBasicItemList(){

        List<UpgradeItemVO> upgradeItemList = new ArrayList<>();

        try {
            String upgradeItem = JsonUtils.getInstance().loadBasicItemData(UPGRADE_ITEM_DATA);
            Type listType = new TypeToken<List<UpgradeItemVO>>(){
            }.getType();
            upgradeItemList = CommonInstances.getGsonInstance().fromJson(upgradeItem, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return upgradeItemList;
    }

    public UpgradeItemVO getBasicItemByName(String itemName){

        for (UpgradeItemVO upgradeItem : upgradeItemList){
            if (upgradeItem.getItemName().equals(itemName)){
                return upgradeItem;
            }
        }
        return null;
    }

}
