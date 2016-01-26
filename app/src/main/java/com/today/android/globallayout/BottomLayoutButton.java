package com.today.android.globallayout;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * Created by sushil on 1/26/16.
 */
public class BottomLayoutButton implements View.OnClickListener {
    private Activity activity;
    private Button addCartBtn,buyNowBtn;

    public BottomLayoutButton(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

    }
}
