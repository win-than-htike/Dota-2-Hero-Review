package xyz.winthanhtike.travelandtour.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winthanhtike on 6/26/16.
 */
public class ItemViewPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mCarryFragmentList = new ArrayList<>();
    private final List<String> mCarryFragmentTitle = new ArrayList<>();

    public ItemViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mCarryFragmentList.get(position);
    }

    public void addFragment(Fragment fragment,String title){

        mCarryFragmentList.add(fragment);
        mCarryFragmentTitle.add(title);

    }

    @Override
    public int getCount() {
        return mCarryFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCarryFragmentTitle.get(position);
    }
}
