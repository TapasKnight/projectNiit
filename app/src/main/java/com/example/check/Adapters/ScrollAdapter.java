package com.example.check.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.check.Models.scroll;
import com.example.check.R;

import java.util.List;

public class ScrollAdapter extends PagerAdapter {


    private List<scroll> sData;
    private LayoutInflater layoutInflater;
    private Context  sContext;

    public ScrollAdapter(List<scroll> sData, Context sContext) {
        this.sData = sData;
        this.sContext = sContext;
    }

    @Override
    public int getCount() {
        return sData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(sContext);
        View view = LayoutInflater.from(sContext).inflate(R.layout.item,container,false);

        ImageView imageView;
        TextView textView;
        imageView = view.findViewById(R.id.scroll_image);
        textView = view.findViewById(R.id.scrollText);
        imageView.setImageResource(sData.get(position).getScrollImage());

        container.addView(view,0);

        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
