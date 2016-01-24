package com.today.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.today.android.R;
import com.today.android.Utils.ListingView;
import com.today.android.VIew.ListItemView;
import com.today.android.model.ShopModel;

import java.util.List;

/**
 * Created by sushil on 1/16/16.
 */
public class ShopAdapter extends BaseAdapter {
    private Context mcontext;
    List<ShopModel>listShopName;
    private static LayoutInflater inflater=null;
    private ImageView shopImage;
    private TextView shopNameText,cityText,addressText;
    private ListingView  view;

    public ShopAdapter(Context context,List<ShopModel>list,ListingView listingView) {
        this.mcontext = context;
        this.listShopName = list;
        this.view = listingView;
        inflater = ( LayoutInflater )mcontext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listShopName.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ShopModel shopModel = listShopName.get(position);
        ViewHolder viewHolder=null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            ListItemView listItemView = new ListItemView(mcontext,view);
            convertView = listItemView;
            viewHolder.listItemView = (ListItemView)convertView;
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.listItemView.setValue(position,shopModel);


        /*shopNameText = (TextView)rowView.findViewById(R.id.shopName);
        cityText = (TextView)rowView.findViewById(R.id.cityText);
        addressText = (TextView)rowView.findViewById(R.id.addressText);

        if (listShopName.get(position).shopName!=null){
            shopNameText.setText(listShopName.get(position).shopName);
        }if (listShopName.get(position).citName!=null){
            cityText.setText(listShopName.get(position).citName);
        }if (listShopName.get(position).address!=null){
            addressText.setText(listShopName.get(position).address);
        }*/
        return convertView;
    }

    class ViewHolder{
        ListItemView listItemView;
    }
}
