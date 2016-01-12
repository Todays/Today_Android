package com.today.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.today.android.R;

public class SplashScreenActivity extends AppCompatActivity implements Animation.AnimationListener {
    private TextView  textwelcome,textViewTo,textViewToday;
    private ImageView imageIcon;
    private  Animation animationBounce;

    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);


       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);FloatingActionButton*/

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    /*initilaize object*/
    private void init() {
        animationBounce = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);
        textwelcome = (TextView)findViewById(R.id.textwelcome);
        //textwelcome.startAnimation(animationBounce);
        textViewTo= (TextView)findViewById(R.id.textto);
       // textViewTo.startAnimation(animationBounce);
        textViewToday = (TextView)findViewById(R.id.texttodays);
      //  textViewToday.startAnimation(animationBounce);
        imageIcon = (ImageView)findViewById(R.id.iconImage);
       // imageIcon.startAnimation(animationBounce);




    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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
    }*/
}
