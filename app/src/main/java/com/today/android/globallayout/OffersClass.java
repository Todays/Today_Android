package com.today.android.globallayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.today.android.R;

import java.util.HashMap;

/**
 * Created by sushil on 1/26/16.
 */
public class OffersClass implements View.OnClickListener ,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    private  Activity activity;
    private SliderLayout sliderLayout;

    public OffersClass(Activity activity) {
        this.activity = activity;

        init();
    }

    private void init() {
        sliderLayout = (SliderLayout)activity.findViewById(R.id.slideroffer);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.offers);
        file_maps.put("Big Bang Theory",R.drawable.offers);
        file_maps.put("House of Cards",R.drawable.offers);
        file_maps.put("Game of Thrones", R.drawable.offers);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(activity);
            // initialize a SliderLayout
            textSliderView
                    //.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
