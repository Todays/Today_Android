package com.today.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.today.android.R;
import com.today.android.constant.HomeItems;

import java.util.List;

/**
 * Created by sushil on 1/9/16.
 */
public class HomeItemAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private List<HomeItems> homeItemsList;

    public HomeItemAdapter(Context context, int layoutResourceId, List<HomeItems> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.homeItemsList = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.image.setImageResource(homeItemsList.get(position).images);

        return row;
    }

    static class ViewHolder {

        ImageView image;
    }
}
