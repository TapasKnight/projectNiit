package com.example.check.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.check.Models.Music;
import com.example.check.R;

import java.util.List;




public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<Music> mData;

    private Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Music> mData) {

        this.mContext = mContext;
        this.mData = mData;

           }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_music,parent,false);
        final ViewHolder vHolder = new ViewHolder(v);

        // Dialog Init

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialouge);

        vHolder.itemMusic.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               TextView dialog_song_tv = (TextView) myDialog.findViewById(R.id.song_name);
               ImageView dialod_somg_img = (ImageView) myDialog.findViewById(R.id.dialod_songImg);
               dialog_song_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
               dialod_somg_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());

               myDialog.show();


               Toast.makeText(mContext,"Text CLick"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
           }
       });
        return vHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvName.setText(mData.get(position).getName());
        holder.mimg.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout itemMusic;
        private TextView tvName;
        private ImageView mimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemMusic = (LinearLayout) itemView.findViewById(R.id.music_item);
            tvName = (TextView) itemView.findViewById(R.id.name_music);
            mimg = (ImageView) itemView.findViewById(R.id.img_music);

        }
    }




}
