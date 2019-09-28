package com.example.check.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.check.Models.Therapist;
import com.example.check.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TherapistCardView extends RecyclerView.Adapter<TherapistCardView.ViewHolder> {

    private Context tContext;
    private List<Therapist> tData;

    public TherapistCardView(Context tContext, List<Therapist> tData) {
        this.tData = tData;
        this.tContext = tContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View t;
        t = LayoutInflater.from(tContext).inflate(R.layout.each_therapist,parent,false);
        return new ViewHolder(t);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.therapistName.setText(tData.get(position).gettName());
        holder.therapistImage.setImageResource(tData.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return tData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout itemTherapist;
        private CircleImageView therapistImage;
        private TextView therapistName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTherapist = (LinearLayout) itemView.findViewById(R.id.therapist_layout);
            therapistName = (TextView) itemView.findViewById(R.id.therapist_name);
            therapistImage = (CircleImageView) itemView.findViewById(R.id.therapist_image);



        }
    }
}
