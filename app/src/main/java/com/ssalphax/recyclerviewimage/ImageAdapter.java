package com.ssalphax.recyclerviewimage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ssalphax on 3/4/2018.
 */

public class ImageAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<String> imgUrl;

    public ImageAdapter(Context context, ArrayList<String> imgUrl) {

        this.context = context;
        this.imgUrl = imgUrl;

    }

    @Override
    public int getCount() {
        return imgUrl.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView img;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.image_view_item, container,
                false);

        img = (ImageView) viewLayout.findViewById(R.id.image_view);

        Glide.with(context).load(imgUrl.get(position)).into(img);

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

}
