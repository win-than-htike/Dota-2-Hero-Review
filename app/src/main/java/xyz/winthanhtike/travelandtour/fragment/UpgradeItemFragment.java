package xyz.winthanhtike.travelandtour.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import xyz.winthanhtike.travelandtour.Dota2HeroApp;
import xyz.winthanhtike.travelandtour.R;
import xyz.winthanhtike.travelandtour.adapter.UpgradeItemRVAdapter;
import xyz.winthanhtike.travelandtour.data.model.UpgradeItemModel;
import xyz.winthanhtike.travelandtour.data.vos.UpgradeItemVO;

/**
 * Created by winthanhtike on 6/26/16.
 */
public class UpgradeItemFragment extends Fragment {

    private UpgradeItemRVAdapter upgradeAdapter;
    private ItemFragment.ControllerItem controllerItem;

    public static UpgradeItemFragment getInstance(){
        return new UpgradeItemFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        upgradeAdapter = new UpgradeItemRVAdapter(UpgradeItemModel.getInstance().getUpgradeItemList(),controllerItem);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controllerItem = (ItemFragment.ControllerItem) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upgrade_item,container,false);

        RecyclerView rvUpgradeItem = (RecyclerView)view.findViewById(R.id.rv_upgrade_item);
        rvUpgradeItem.setAdapter(upgradeAdapter);
        rvUpgradeItem.setLayoutManager(new LinearLayoutManager(Dota2HeroApp.getContext(),LinearLayoutManager.VERTICAL,false));

        return view;
    }
}
