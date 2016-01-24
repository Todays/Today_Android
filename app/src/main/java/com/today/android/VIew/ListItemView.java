package com.today.android.VIew;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.today.android.R;
import com.today.android.Utils.ListingView;
import com.today.android.application.AppController;
import com.today.android.model.ShopModel;

/**
 * Created by sushil on 1/17/16.
 */
public class ListItemView extends RelativeLayout {

    private Context mContext;
    private int imgWidth=100, imgHeight=100;
    private  ListingView listingView;
    private int placeholderImage = R.drawable.placeholder;
    private  RelativeLayout layoutDetail;
    private ImageView shopImage;
    private TextView shopNameText,cityText,addressText;

    public ListItemView(Context context,ListingView listingView) {
        super(context);
        mContext =(Activity) context;
        this.listingView = listingView;
        setImageWidthAndHeight();
        setPlaceHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.customshopgrid, null);
        initViews(view);
        addView(view);
        updateViews();
    }

    private void setImageWidthAndHeight() {
        int[] size = AppController.getInstance().getImageSize(listingView);
        imgWidth = size[0];
        imgHeight = size[1];
    }

    private void setPlaceHolder() {
        if(listingView == ListingView.GRIDVIEW){
            placeholderImage = R.drawable.placeholder;
        }else if(listingView == ListingView.SINGLEVIEW){
            placeholderImage = R.drawable.placeholder;
        }else if(listingView == ListingView.LISTVIEW){
            placeholderImage = R.drawable.placeholder;
        }
    }

    private void initViews(View view) {
        shopImage = (ImageView)view.findViewById(R.id.shopImage);
        shopNameText = (TextView)view.findViewById(R.id.shopName);
        cityText = (TextView)view.findViewById(R.id.cityText);
        addressText = (TextView)view.findViewById(R.id.addressText);
        layoutDetail = (RelativeLayout) view.findViewById(R.id.rlDesc);

    }

    /* update value on switch button click*/
    private void updateViews() {

        if(listingView==ListingView.LISTVIEW){
            LayoutParams lp1 = new LayoutParams(imgWidth, imgHeight);
            lp1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            lp1.addRule(RelativeLayout.CENTER_VERTICAL);
            lp1.leftMargin = 3;
            shopImage.setLayoutParams(lp1);

            LayoutParams lp2 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            lp2.addRule(RelativeLayout.RIGHT_OF,R.id.shopImage);
            lp2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutDetail.setLayoutParams(lp2);
            //				viewContainer.bAddToCart.setVisibility(View.VISIBLE);

        }else{



            LayoutParams lp2 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            lp2.addRule(RelativeLayout.BELOW,R.id.shopImage);
            layoutDetail.setLayoutParams(lp2);


        }
    }
    /* set list value*/
    public  void setValue(int position, ShopModel shopModel){
        setAddress(shopModel.address);
        setCity(shopModel.citName);
        setShopName(shopModel.shopName);

    }

    public void setShopName(String shopName){
        shopNameText.setText(shopName);
    }
    public void setCity(String city){
        cityText.setText(city);
    }
    public void setAddress(String address){
        addressText.setText(address);
    }
}
