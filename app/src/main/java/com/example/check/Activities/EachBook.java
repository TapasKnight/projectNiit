package com.example.check.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.check.R;

import org.w3c.dom.Text;

public class EachBook extends AppCompatActivity {


    private TextView tvTitle, tvDescription;
    private TextView bookContent;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_book);

        tvTitle = (TextView) findViewById(R.id.bookTitle);
        tvDescription = (TextView) findViewById(R.id.bookDescription);
        bookContent  = (TextView) findViewById(R.id.Description);
        img = (ImageView) findViewById(R.id.Book_activity_thumbnail);


            /// Recieve Data
        Intent intent = getIntent();

        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int Image = intent.getExtras().getInt("Thumbnail");


        // Setting Value
       tvTitle.setText(Title);
       tvDescription.setText(Description);
       img.setImageResource(Image);
    }
}
