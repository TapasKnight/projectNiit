package com.example.check.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.check.Activities.stopwatchActivity;
import com.example.check.Models.grid_home;
import com.example.check.R;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {



    private Dialog myDialog;

     private Context gContext;
     private List<grid_home> gData;

    public GridViewAdapter(Context gContext, List<grid_home> gData) {
        this.gContext = gContext;
        this.gData = gData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View g;

        g = LayoutInflater.from(gContext).inflate(R.layout.item_home_grid,parent,false);


        final ViewHolder vHolder =  new ViewHolder(g);

    vHolder.itemGrid.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(gContext, stopwatchActivity.class);
            gContext.startActivity(intent);



        }
    });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.imgGrid.setImageResource(gData.get(position).getGridImage());

    }

    @Override
    public int getItemCount() {
        return gData.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgGrid;
        CardView grid;
        LinearLayout itemGrid,itemList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemGrid = (LinearLayout) itemView.findViewById(R.id.grid_layout);
            grid = (CardView)  itemView.findViewById(R.id.gridView_home);
            imgGrid = (ImageView) itemView.findViewById(R.id.grid_img);

        }
    }
}
