package com.today.android.Utils;

/**
 * Created by sushil on 1/16/16.
 */
public enum ListingView {
    GRIDVIEW(0), SINGLEVIEW(1), LISTVIEW(2);
    private int value;

    private ListingView(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
