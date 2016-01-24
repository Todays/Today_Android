package com.today.android.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.today.android.R;

public class ShopDeatailActivity extends AppCompatActivity {
    LinearLayout Linearlayout;
    ScrollView scrollView;
    String collecitionName [] = {"Indian Wear", " Western Wear","Lingeries","Indian Wear", " Western Wear","Lingeries"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_deatail);
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
        scrollView = (ScrollView)findViewById(R.id.scrollview);
        LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramss.setMargins(30, 30, 10, 30);
        Linearlayout =  new LinearLayout(this);
        Linearlayout.setLayoutParams(paramss);
        Linearlayout.setOrientation(LinearLayout.VERTICAL);



        for (int i = 0; i <6 ; i++) {
            LinearLayout.LayoutParams textHeadLayoutParam = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textHeadLayoutParam.setMargins(20, 20, 0, 0);
            TextView CollectionName = new TextView(this);
            CollectionName.setText(collecitionName[i]);
            CollectionName.setTypeface(Typeface.DEFAULT_BOLD);
            CollectionName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            CollectionName.setTextColor(getResources().getColor(R.color.colorAccent));
            CollectionName.setGravity(Gravity.CENTER);
            CollectionName.setLayoutParams(textHeadLayoutParam);
            Linearlayout.addView(CollectionName);



            Linearlayout.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            HorizontalScrollView scroll = new HorizontalScrollView(this);

            scroll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));



            // create the layout params that will be used to define how your
            // button will be displayed
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                     LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout lls = new LinearLayout(this);
            lls.setLayoutParams(params);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);




            lls.setOrientation(LinearLayout.HORIZONTAL);


            //Create four
            for(int j=0;j<=4;j++) {
                // Create LinearLayout
                LinearLayout ll = new LinearLayout(this);
                layoutParams.setMargins(30, 10, 30, 0);
                ll.setLayoutParams(layoutParams);
                ll.setBackgroundColor(Color.WHITE);
                ll.setOrientation(LinearLayout.VERTICAL);
            /*ImageView*/

                LinearLayout.LayoutParams imageLayoutParam = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                imageLayoutParam.setMargins(20, 20, 20, 5);

                LinearLayout.LayoutParams textLayoutParam = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                textLayoutParam.setMargins(20, 0, 20, 5);
                LinearLayout.LayoutParams cartLayoutParam = new LinearLayout.LayoutParams(60,60);
                cartLayoutParam.setMargins(20, 0, 20, 15);

                LinearLayout imageParam = new LinearLayout(this);
                imageParam.layout(0, 0, 200, 200);
                imageParam.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                imageParam.setOrientation(LinearLayout.HORIZONTAL);
                ImageView myImage = new ImageView(this);
                myImage.setImageResource(R.drawable.placeholder);
                myImage.setLayoutParams(imageLayoutParam);
                imageParam.addView(myImage);

                ll.addView(imageParam);
                // Create TextView
                TextView productNameText = new TextView(this);
                productNameText.setText(" Product" + j + "    ");
                productNameText.setTypeface(Typeface.DEFAULT_BOLD);
                productNameText.setTextColor(getResources().getColor(R.color.colorWhite));
                productNameText.setLayoutParams(textLayoutParam);
                ll.addView(productNameText);

                // Create TextView
                TextView priceText = new TextView(this);
                priceText.setText("  $" + j + "     ");
                priceText.setTextColor(getResources().getColor(R.color.colorWhite));
                priceText.setLayoutParams(textLayoutParam);
                ll.addView(priceText);

                // Create Button
                final ImageButton btn = new ImageButton(this);
                // Give button an ID
                btn.setId(j + 1);
                btn.setImageResource(R.drawable.addcart);
                btn.setBackgroundResource(R.drawable.roundedbutton);
                btn.setLayoutParams(cartLayoutParam);


                final int index = j;
                // Set click listener for button
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Log.i("TAG", "index :" + index);

                        Toast.makeText(getApplicationContext(),
                                "Clicked Button Index :" + index,
                                Toast.LENGTH_LONG).show();

                    }
                });

                //Add button to LinearLayout
                ll.addView(btn);
                ll.setBackgroundResource(R.drawable.view_rounded);
                lls.addView(ll);


            }

            scroll.addView(lls);

            Linearlayout.addView(scroll);
        }
        scrollView.addView(Linearlayout);
        //scroll.addView(yourTableView);
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
