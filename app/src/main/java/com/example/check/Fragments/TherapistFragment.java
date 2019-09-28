package com.example.check.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.check.Adapters.TherapistCardView;
import com.example.check.Models.Therapist;
import com.example.check.R;

import java.util.ArrayList;
import java.util.List;

public class TherapistFragment extends Fragment implements View.OnClickListener{

    public Button call_Pawan,call_josiah,call_Ridge,call_Shubham,call_Bhavesh;
    public String Numb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_therapist, container, false);

        call_Pawan = (Button) view.findViewById(R.id.callPawan);
        call_Pawan.setOnClickListener(this);
        call_josiah = (Button) view.findViewById(R.id.callJosiah);
        call_josiah.setOnClickListener(this);
        call_Bhavesh = (Button) view.findViewById(R.id.callBhavesh);
        call_Bhavesh.setOnClickListener(this);
        call_Shubham = (Button) view.findViewById(R.id.callShubham);
        call_Shubham.setOnClickListener(this);
        call_Ridge = (Button) view.findViewById(R.id.callRidge);
        call_Ridge.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
          int id = v.getId();

          switch(id){

              case R.id.callRidge:
                  Numb = "8369452215";
                  break;
              case R.id.callBhavesh:
                  Numb = "9967948589";
                  break;
              case R.id.callPawan:
                  Numb = "0123456789";
                  break;
              case R.id.callJosiah:
                  Numb = "9876543210";
                  break;
              case R.id.callShubham:
                  Numb = "8527419630";
          }


        Intent calling = new Intent(Intent.ACTION_DIAL);
        calling.setData(Uri.parse("tel:" +Numb));
        startActivity(calling);
    }
}

