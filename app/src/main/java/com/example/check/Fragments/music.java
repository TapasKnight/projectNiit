package com.example.check.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.check.Adapters.RecyclerViewAdapter;
import com.example.check.Models.Music;
import com.example.check.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class music extends Fragment {


    View v;
    private RecyclerView myRecyclerView;
    private List<Music> lstmusic;


    public music() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_music, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.recyler_music);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstmusic);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    lstmusic = new ArrayList<>();
    lstmusic.add(new Music("Meditating",R.drawable.logo));
        lstmusic.add(new Music("Meditating",R.drawable.logo));
        lstmusic.add(new Music("Relaxing",R.drawable.logo));
        lstmusic.add(new Music("Melodies",R.drawable.logo));
        lstmusic.add(new Music("Waves",R.drawable.logo));
        lstmusic.add(new Music("Beach",R.drawable.logo));
        lstmusic.add(new Music("Symphony",R.drawable.logo));
        lstmusic.add(new Music("Rock",R.drawable.logo));
        lstmusic.add(new Music("Jazz",R.drawable.logo));
        lstmusic.add(new Music("Pop",R.drawable.logo));
        lstmusic.add(new Music("Indie",R.drawable.logo));
        lstmusic.add(new Music("Urban",R.drawable.logo));
        lstmusic.add(new Music("Turba",R.drawable.logo));
        lstmusic.add(new Music("House",R.drawable.logo));




    }


}
