package com.fluper.foodtruckuser.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.databinding.FragmentAboutBinding;


// todo remove find view by id from everywhere...
public class AboutFragment extends Fragment {
    private FragmentAboutBinding mFragmentAboutBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,Bundle savedInstanceState) {
        mFragmentAboutBinding =   DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false);
        return mFragmentAboutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentAboutBinding.ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });
    }
}
