package com.today.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.today.android.Listner.RecycleViewClickListner;
import com.today.android.R;
import com.today.android.model.CategoryModel;

import java.util.List;

/**
 * Created by sushil on 1/10/16.
 */
public class DerailcategoryAdaoter extends  RecyclerView.Adapter<CategoryViewHolder> {


private List<CategoryModel> categoryModelList;

private Context mContext;
private RecycleViewClickListner mrecycleViewClickListner;

public DerailcategoryAdaoter(Context context, List<CategoryModel> ItemList,RecycleViewClickListner clickListner) {
        this.categoryModelList = ItemList;
        this.mContext = context;
        this.mrecycleViewClickListner = clickListner;
        }

@Override
public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customdetailcategory, null);
        CategoryViewHolder mh = new CategoryViewHolder(v,mrecycleViewClickListner);
        return mh;
        }

@Override
public void onBindViewHolder(CategoryViewHolder categoryListRowHolder, int i) {
        CategoryModel cateItem = categoryModelList.get(i);

        categoryListRowHolder.thumbnail.setImageResource(cateItem.thumbnail);
        categoryListRowHolder.title.setText(cateItem.title);

        //Picasso.with(mContext).load(feedItem.getThumbnail())
        //.error(R.drawable.placeholder)
        //.placeholder(R.drawable.placeholder)
        //.into(feedListRowHolder.thumbnail);

        //feedListRowHolder.title.setText(Html.fromHtml(feedItem.getTitle()));
        }

@Override
public int getItemCount() {
        return (null != categoryModelList ? categoryModelList.size() : 0);
        }
        }