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
import xyz.winthanhtike.travelandtour.adapter.BasicItemRVAdapter;
import xyz.winthanhtike.travelandtour.data.model.BasicItemModel;
import xyz.winthanhtike.travelandtour.data.vos.BasicItemVO;

/**
 * Created by winthanhtike on 6/26/16.
 */
public class BasicItemFragment extends Fragment {

    private BasicItemRVAdapter adapter;
    private ControllerBasicItem mBasicItem;

    public static BasicItemFragment getInstance(){
        return new BasicItemFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBasicItem = (ControllerBasicItem) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new BasicItemRVAdapter(BasicItemModel.getInstance().getBasicItemList(),mBasicItem);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basci_item,container,false);

        RecyclerView rvBasicItem = (RecyclerView)view.findViewById(R.id.rv_basic_item);
        rvBasicItem.setAdapter(adapter);
        rvBasicItem.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        return view;
    }

    public interface ControllerBasicItem{
        void onTapBasicItem(BasicItemVO basicItemVO, ImageView ivBasicItemImage);
    }

}
