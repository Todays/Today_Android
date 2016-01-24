package com.today.android.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;

import com.today.android.R;

/**
 * Created by sushil on 1/16/16.
 */
public class CommonWork {
    public static final int SCREEN_480 = 4801590;
    public static final int SCREEN_720 = 7201590;
    public static final int SCREEN_1080 = 10801590;
    public void changeActivity(Context context,Class classToChange){
        Intent intent = new Intent(context,classToChange);
        context.startActivity(intent);


    }


}
