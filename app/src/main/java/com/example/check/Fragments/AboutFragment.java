package com.example.check.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import de.hdodenhof.circleimageview.CircleImageView;



import com.example.check.R;


public class AboutFragment extends Fragment {


    CircleImageView developerImage;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        developerImage = (CircleImageView) view.findViewById(R.id.nav_user_photo);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        developerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Photo of the Developer",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
