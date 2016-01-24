package com.today.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.today.android.Listner.RecycleViewClickListner;
import com.today.android.R;

/**
 * Created by sushil on 1/10/16.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected ImageView thumbnail;
    protected TextView title;
    protected RecycleViewClickListner recycleViewClickListner;

    public CategoryViewHolder(View view,RecycleViewClickListner clickListner) {
        super(view);
        this.recycleViewClickListner=clickListner;
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        recycleViewClickListner.recyclerViewListClicked(v,this.getAdapterPosition());

    }
}
