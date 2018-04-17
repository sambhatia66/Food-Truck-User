package com.fluper.foodtruckuser.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.adapter.MenuItemAdapter;

public class MenuFragment extends Fragment {


    private RecyclerView recyclerView;
    MenuItemAdapter menuItemAdapter;
    LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView =  view.findViewById(R.id.rl_menu);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        menuItemAdapter = new MenuItemAdapter(getActivity());
        recyclerView.setAdapter(menuItemAdapter);



        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
