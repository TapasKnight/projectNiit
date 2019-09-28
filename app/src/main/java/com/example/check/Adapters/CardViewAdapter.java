package com.example.check.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.check.Activities.EachBook;
import com.example.check.Models.Book;
import com.example.check.R;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private Context bContext;
    private List<Book> bData;


    public CardViewAdapter(Context bContext, List<Book> bData) {
        this.bContext = bContext;
        this.bData = bData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View b;
        b = LayoutInflater.from(bContext).inflate(R.layout.cardview_item_book,parent,false);
        return  new ViewHolder(b);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        viewHolder.bookName.setText(bData.get(position).getTitle());
        viewHolder.bookImg.setImageResource(bData.get(position).getThumbnail());


        // set click Listener
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     /// passing data to book activity
              Intent intent = new Intent(bContext, EachBook.class);
              intent.putExtra("Book Title",bData.get(position).getTitle());
                intent.putExtra("Description",bData.get(position).getDescription());
                intent.putExtra("Thumbnail",bData.get(position).getThumbnail());

                // ***************** start Activity
                bContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return bData.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        LinearLayout itemBooks;
        private TextView bookName ;
        private ImageView bookImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           itemBooks = (LinearLayout) itemView.findViewById(R.id.book_layout);
           bookName = (TextView) itemView.findViewById(R.id.book_title);
           bookImg = (ImageView) itemView.findViewById(R.id.book_img);
           cardView = (CardView) itemView.findViewById(R.id.card_view_book);

        }
    }




}
