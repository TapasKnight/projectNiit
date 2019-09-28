package com.example.check.Fragments;


import android.animation.ArgbEvaluator;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.check.Adapters.GridViewAdapter;
import com.example.check.Adapters.ScrollAdapter;
import com.example.check.Models.Book;
import com.example.check.Models.grid_home;
import com.example.check.Models.scroll;
import com.example.check.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class intro extends Fragment {

    View g;

    List<grid_home> lstGrid;

    private RecyclerView gridRecyclerView;


    public intro() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Scroll view properties



        // viewPager.setPadding(130,0,130,0);

        g =  inflater.inflate(R.layout.fragment_intro, container, false);
        gridRecyclerView = (RecyclerView) g.findViewById(R.id.grid_home_layout);
        GridViewAdapter cardViewAdapter = new GridViewAdapter(getContext(),lstGrid);
        gridRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        gridRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        gridRecyclerView.setAdapter(cardViewAdapter);

       return g;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstGrid = new ArrayList<>();
        lstGrid.add(new grid_home(R.drawable.positive2));
        lstGrid.add(new grid_home(R.drawable.breathing2));
        lstGrid.add(new grid_home(R.drawable.run));
        lstGrid.add(new grid_home(R.drawable.skipp));
        lstGrid.add(new grid_home(R.drawable.cycling));
    }
}
