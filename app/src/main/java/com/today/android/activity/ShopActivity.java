package com.today.android.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.today.android.R;
import com.today.android.Utils.CommonWork;
import com.today.android.Utils.ListingView;
import com.today.android.adapter.ShopAdapter;
import com.today.android.model.ShopModel;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RelativeLayout shortLayout, filterLayout,switchViewLayout;
    private GridView shopGridView;
    private ShopAdapter shopAdapter;
    private String[] shopName = {"Deshmukh shop", "Ira Collection", "Vedh shoping center", "Deshmukh shop", "Ira Collection", "Vedh shoping center"};
    private String[] city = {"Pune", "Banglore", "Delhi", "Pune", "Banglore", "Delhi"};
    private String[] address = {"Kalyani nagar", "wester road ", "rohini sector 34", "Kalyani nagar", "wester road ", "rohini sector 34"};
    private ImageView switchViewImage;
    private List<ShopModel> listShopModel;
    ListingView viewType = ListingView.SINGLEVIEW;
    int numOfColumns = 1;
    private CommonWork commonWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }

    private void init() {
        shortLayout = (RelativeLayout) findViewById(R.id.rlBtnSort);
        filterLayout = (RelativeLayout) findViewById(R.id.rlBtnFilter);
        switchViewLayout = (RelativeLayout)findViewById(R.id.rlBtnSitchNext);
        switchViewLayout.setOnClickListener(this);
        switchViewImage = (ImageView)findViewById(R.id.imageSwitch);
        shopGridView = (GridView) findViewById(R.id.gridviewShop);
        shopGridView.setOnItemClickListener(this);
        listShopModel = new ArrayList<ShopModel>();
        for (int i = 0; i < 6; i++) {
            ShopModel shopModel = new ShopModel();
            shopModel.shopName = shopName[i];
            shopModel.citName =  city[i];
            shopModel.address = address[i];
            listShopModel.add(shopModel);

        }
        shopAdapter = new ShopAdapter(ShopActivity.this, listShopModel,viewType);
        shopGridView.setNumColumns(numOfColumns);
        shopGridView.setAdapter(shopAdapter);
        commonWork = new CommonWork();

    }

    private void setViewType(String type){
        if(type.equalsIgnoreCase("S")){
            viewType = ListingView.SINGLEVIEW;
            numOfColumns = 1;
        }
        else if(type.equalsIgnoreCase("L")){
            viewType = ListingView.LISTVIEW;
            numOfColumns = 1;
        }
        else if(type.equalsIgnoreCase("G")){
            viewType = ListingView.GRIDVIEW;
            numOfColumns = 2;
        }
    }

    private void setSwitchmodeIconSelector() {
        if(viewType==ListingView.GRIDVIEW)
            switchViewImage.setImageResource(R.drawable.ic_switch_icon_selector);
        else if(viewType==ListingView.SINGLEVIEW)
            switchViewImage.setImageResource(R.drawable.ic_switch_icon_list_selector);
        else if(viewType==ListingView.LISTVIEW)
            switchViewImage.setImageResource(R.drawable.ic_switch_icon_grid_selector);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.rlBtnSitchNext:


                if(shopGridView.getAdapter()!=null && shopGridView.getAdapter().getCount()==0)
                    return;

                if(viewType==ListingView.GRIDVIEW){
                    shopAdapter = new ShopAdapter(ShopActivity.this, listShopModel,ListingView.SINGLEVIEW);
                    shopGridView.setAdapter(shopAdapter);
                    shopGridView.setNumColumns(1);
                    numOfColumns = 1;
                    viewType = ListingView.SINGLEVIEW;
                }else if(viewType==ListingView.SINGLEVIEW){
                    shopAdapter = new ShopAdapter(this, listShopModel, ListingView.LISTVIEW);
                    shopGridView.setAdapter(shopAdapter);
                    shopGridView.setNumColumns(1);
                    numOfColumns = 1;
                    viewType = ListingView.LISTVIEW;
                }else if(viewType==ListingView.LISTVIEW){
                    shopAdapter = new ShopAdapter(this, listShopModel, ListingView.GRIDVIEW);
                    shopGridView.setAdapter(shopAdapter);
                    shopGridView.setNumColumns(2);
                    numOfColumns = 2;
                    viewType = ListingView.GRIDVIEW;
                }
                setSwitchmodeIconSelector();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        commonWork.changeActivity(this, ShopDeatailActivity.class);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

    }
}
