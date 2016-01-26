package com.today.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.today.android.R;
import com.today.android.adapter.HomeItemAdapter;
import com.today.android.constant.HomeItems;
import com.today.android.globallayout.MyFavorite;
import com.today.android.globallayout.OffersClass;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {
    private GridView homeGridView;
    private HomeItemAdapter homeItemAdapter;
    private String TAG = "HomeActivity";
    private OffersClass offersClass;
    private RelativeLayout myfavroiteLayout;
    private LinearLayout homeMainLayout;
    private int flagviewChange=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myfavroiteLayout = (RelativeLayout)findViewById(R.id.myfavlay);
        homeMainLayout =(LinearLayout)findViewById(R.id.homemainlay);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "My Favorite List", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                MyFavorite myFavorite = new MyFavorite(HomeActivity.this);
                if (flagviewChange == 0) {

                    homeMainLayout.setVisibility(View.GONE);
                    myfavroiteLayout.setVisibility(View.VISIBLE);
                    fab.setImageResource(R.drawable.crossred);
                    flagviewChange=1;
                }else {
                    flagviewChange=0;
                    homeMainLayout.setVisibility(View.VISIBLE);
                    myfavroiteLayout.setVisibility(View.GONE);
                    fab.setImageResource(R.drawable.ic_wishlist_red);
                }


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
    }

    private void init() {

        homeGridView = (GridView) findViewById(R.id.homeGridView);
        homeGridView.setOnItemClickListener(this);
        homeItemAdapter = new HomeItemAdapter(this, R.layout.customhomeitem, getItem());
        homeGridView.setAdapter(homeItemAdapter);
        offersClass = new OffersClass(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_shop) {
            // Handle the camera action
        } else if (id == R.id.nav_food) {

        } else if (id == R.id.nav_health) {

        } else if (id == R.id.nav_transport) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public List<HomeItems> getItem() {
        List<HomeItems> homeItemsList = new ArrayList<>();
        List<Integer> image = new ArrayList<>();
        image.add(R.drawable.shop);
        image.add(R.drawable.food);
        image.add(R.drawable.health);
        image.add(R.drawable.transport);
        for (int i = 1; i < 5; i++) {
            HomeItems homeItems = new HomeItems();

            homeItems.id = i;
            homeItems.images = image.get(i - 1);
            homeItemsList.add(homeItems);
        }
        return homeItemsList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this,DetailCategoryActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

    }
}
