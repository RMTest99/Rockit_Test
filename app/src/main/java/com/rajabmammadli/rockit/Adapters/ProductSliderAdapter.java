package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.rajabmammadli.rockit.R;

import java.lang.reflect.Field;

public class ProductSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public ProductSliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {
            R.drawable.nikeairforce1,
            R.drawable.nikeairforce2,
            R.drawable.nikeairforce3,
            R.drawable.nikeairforce4
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.product_slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.product_slide_image);

        slideImageView.setImageResource(slide_images[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
