package xyz.winthanhtike.travelandtour.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.winthanhtike.travelandtour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuildFragment extends Fragment {


    public BuildFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_build, container, false);
        return view;
    }

}
