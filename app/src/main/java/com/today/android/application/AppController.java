package com.today.android.application;

import android.app.Application;
import android.view.ViewGroup;

import com.today.android.Utils.CommonWork;
import com.today.android.Utils.ListingView;

/**
 * Created by sushil on 1/17/16.
 */
public class AppController extends Application {
    private int resolutionType = CommonWork.SCREEN_480;
    public double density = 0.0;
    private static AppController mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    public static synchronized AppController getInstance() {
        /**initialise Application Context*/
        return mInstance;
    }

    public int getScalingFactor(int value) {
        return (int) ((value / 1.5) * density);
    }

    public int[] getZoomingImgeHeightWidth() {
        int type = getResolutionType();
        int imgWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
        int imgHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
        int dim[] = new int[2];
        switch (type) {
            case CommonWork.SCREEN_480:
                // 339x411
                imgWidth = 339;// (int) getScalingFactor(339);
                imgHeight = 411;// (int) getScalingFactor(411);

                break;
            case CommonWork.SCREEN_720:
                // 509x617
                imgWidth = 509;// (int) getScalingFactor(509);
                imgHeight = 617;// (int) getScalingFactor(617);
                break;
            case CommonWork.SCREEN_1080:
                // 764x926
                imgWidth = 764;// (int) getScalingFactor(764);
                imgHeight = 926;// (int) getScalingFactor(926);
                break;

            default:
                break;
        }
        dim[0] = imgWidth;
        dim[1] = imgHeight;
        return dim;
    }

    public int[] getProductDetailImgeHeightWidth() {
        int type = getResolutionType();
        int imgWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
        int imgHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
        int dim[] = new int[2];
        switch (type) {
            case CommonWork.SCREEN_480:
                // 339x411
                imgWidth = 339;// (int) getScalingFactor(339);
                imgHeight = 441;// (int) getScalingFactor(411);
                break;
            case CommonWork.SCREEN_720:
                // 509x617
                imgWidth = 509;// (int) getScalingFactor(509);
                imgHeight = 617;// (int) getScalingFactor(617);
                break;
            case CommonWork.SCREEN_1080:
                // 764x926
                imgWidth = 764;// (int) getScalingFactor(764);
                imgHeight = 926;// (int) getScalingFactor(926);
                break;

            default:
                break;
        }
        dim[0] = imgWidth;
        dim[1] = imgHeight;
        return dim;
    }

    // YML/ BT/ ShortListed/ RecentlyViewd ( HorizontalListView)
    public int[] getProductThumbImgeHeightWidth() {
        int type = getResolutionType();

        int imgWidth = getScalingFactor(120);
        int imgHeight = getScalingFactor(146);
        int dim[] = new int[2];

        switch (type) {
            case CommonWork.SCREEN_480:
                // 120x146
                imgWidth = 120;// (int)
                // AppController.getInstance().getScalingFactor(120);
                imgHeight = 146;// (int)
                // AppController.getInstance().getScalingFactor(146);
                break;
            case CommonWork.SCREEN_720:
                // 180x218
                imgWidth = 180;// (int)
                // AppController.getInstance().getScalingFactor(180);
                imgHeight = 218;// (int)
                // AppController.getInstance().getScalingFactor(218);
                break;
            case CommonWork.SCREEN_1080:
                // 270x327
                imgWidth = 270;// (int)
                // AppController.getInstance().getScalingFactor(270);
                imgHeight = 327;// (int)
                // AppController.getInstance().getScalingFactor(327);
                break;

        }
        dim[0] = imgWidth;
        dim[1] = imgHeight;
        return dim;
    }

    public int[] getImageSize(ListingView listingView) {
        int[] size;
        int type = AppController.getInstance().getResolutionType();
        switch (type) {
            case CommonWork.SCREEN_480:
                size = getImageSizeFor480(listingView);
                break;
            case CommonWork.SCREEN_720:
                size = getImageSizeFor720(listingView);
                break;
            case CommonWork.SCREEN_1080:
                size = getImageSizeFor1080(listingView);
                break;

            default:
                size = new int[2];
                size[0] = (int) AppController.getInstance().getScalingFactor(100);
                size[1] = (int) AppController.getInstance().getScalingFactor(100);

                break;
        }
        return size;
    }

    private int[] getImageSizeFor1080(ListingView listingView) {
        int[] size = new int[2];
        if (listingView == ListingView.GRIDVIEW) {
            // 287x348
            size[0] = 287;
            size[1] = 348;
        } else if (listingView == ListingView.SINGLEVIEW) {
            // 610x739
            size[0] = 610;
            size[1] = 739;
        } else if (listingView == ListingView.LISTVIEW) {
            // 243x294
            size[0] = 243;
            size[1] = 294;
        }
        return size;
    }

    // xhdpi
    private int[] getImageSizeFor720(ListingView listingView) {
        int[] size = new int[2];
        if (listingView == ListingView.GRIDVIEW) {
            // 191x231
            size[0] = 191;
            size[1] = 231;
        } else if (listingView == ListingView.SINGLEVIEW) {
            // 406x492
            size[0] = 406;
            size[1] = 492;
        } else if (listingView == ListingView.LISTVIEW) {
            // 165x200
            size[0] = 165;
            size[1] = 200;
        }
        return size;
    }

    // hdpi
    private int[] getImageSizeFor480(ListingView listingView) {
        int[] size = new int[2];
        if (listingView == ListingView.GRIDVIEW) {
            // 127x154
            size[0] = 127;
            size[1] = 154;
        } else if (listingView == ListingView.SINGLEVIEW) {
            // 270x327
            size[0] = 270;
            size[1] = 327;
        } else if (listingView == ListingView.LISTVIEW) {
            // 108x131
            size[0] = 108;
            size[1] = 131;
        }
        return size;
    }

    public int getResolutionType() {
        return resolutionType;
    }
}
