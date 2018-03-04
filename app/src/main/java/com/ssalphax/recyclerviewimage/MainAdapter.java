package com.ssalphax.recyclerviewimage;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssalphax on 3/4/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Data> dataList;

    public MainAdapter(Context context, List<Data> dataList) {

        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.main_item_row, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Data d= dataList.get(position);
        holder.textView.setText(d.getName());

        ArrayList<String> imgUrl = d.getImage();

        ImageAdapter adapter = new ImageAdapter(context, imgUrl);

        holder.pager.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewPager pager;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            pager = (ViewPager) itemView.findViewById(R.id.view_pager);
            textView = (TextView) itemView.findViewById(R.id.txt_name);

        }
    }
}
