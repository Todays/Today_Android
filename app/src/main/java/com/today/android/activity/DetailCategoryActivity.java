package com.today.android.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.today.android.R;
import com.today.android.adapter.DerailcategoryAdaoter;
import com.today.android.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;


public class DetailCategoryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DerailcategoryAdaoter derailcategoryAdaoter;
    private List<CategoryModel> modelList;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);
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
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_detail_category);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
       // mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
       // gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        //mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);


        derailcategoryAdaoter = new DerailcategoryAdaoter(this,initializeData());
        mRecyclerView.setAdapter(derailcategoryAdaoter);
        // specify an adapter (see also next example)
       // mAdapter = new CategoryAdapter(myDataset);
        //mRecyclerView.setAdapter(mAdapter);
    }


    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    public List<CategoryModel> initializeData() {
        modelList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CategoryModel model;
            switch (i){
                case 0:
                    model = new CategoryModel();
                    model.title = "Watches";
                    model.thumbnail = R.drawable.icon1;
                    modelList.add(model);
                    break;
                case 1:
                    model = new CategoryModel();
                    model.title = "Clothes";
                    model.thumbnail = R.drawable.icon2;
                    modelList.add(model);
                    break;
                case 2:
                    model = new CategoryModel();
                    model.title = "Toys";
                    model.thumbnail = R.drawable.icon3;
                    modelList.add(model);
                    break;
                case 3:
                    model = new CategoryModel();
                    model.title = "Furniture";
                    model.thumbnail = R.drawable.icon4;
                    modelList.add(model);
                    break;
                case 4:
                    model = new CategoryModel();
                    model.title = "Electronic";
                    model.thumbnail = R.drawable.icon5;
                    modelList.add(model);
                    break;
                case 5:
                    model = new CategoryModel();
                    model.title = "Accessories";
                    model.thumbnail = R.drawable.icon6;
                    modelList.add(model);
                    break;

                ////
                case 6:
                    model = new CategoryModel();
                    model.title = "Watches";
                    model.thumbnail = R.drawable.icon1;
                    modelList.add(model);
                    break;
                case 7:
                    model = new CategoryModel();
                    model.title = "Clothes";
                    model.thumbnail = R.drawable.icon2;
                    modelList.add(model);
                    break;
                case 8:
                    model = new CategoryModel();
                    model.title = "Toys";
                    model.thumbnail = R.drawable.icon3;
                    modelList.add(model);
                    break;
                case 9:
                    model = new CategoryModel();
                    model.title = "Furniture";
                    model.thumbnail = R.drawable.icon4;
                    modelList.add(model);
                    break;
                case 10:
                    model = new CategoryModel();
                    model.title = "Electronic";
                    model.thumbnail = R.drawable.icon5;
                    modelList.add(model);
                    break;
                case 11:
                    model = new CategoryModel();
                    model.title = "Accessories";
                    model.thumbnail = R.drawable.icon6;
                    modelList.add(model);
                    break;

            }

        }
        return  modelList;

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

}
