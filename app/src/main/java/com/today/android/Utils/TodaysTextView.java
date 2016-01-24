package com.today.android.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sushil on 1/16/16.
 */
public class TodaysTextView extends TextView {

    public static final int TODAYE_TEXT_LIGHT = 1;
    public static final int TODAYE_TEXT_REGULAR = 2;
    public static final int TODAYE_TEXT_THIN = 3;
    public static final int TODAYE_TEXT_BOLD = 4;
    public static final int TODAYE_TEXT_BOLD_ITALIC = 5;
    public static final int TODAYE_TEXT_LIGHT_ITALIC = 11;

    public static final int STYLE_NORMAL = 1;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_BOLD = 3;

    Context mContext;
    int mFontType = 1;
    int mFontStyle = 1;

    public TodaysTextView(Context context) {
        super(context);
        mContext = context;
    }
    public TodaysTextView(Context context, int aFontName, int aFontStyle) {
        super(context);

        mContext = context;
    }

    public TodaysTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mFontType = attrs.getAttributeIntValue(null, "font_name", 1);
        mFontStyle = attrs.getAttributeIntValue(null, "font_style", 1);
        setTextStyle(mFontType, mFontStyle);
    }

    public TodaysTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;

    }

    public void setTextStyle(int aFontType, int aFontStyle) {
        Typeface tf;
        switch (aFontType) {
            case TODAYE_TEXT_LIGHT:
                tf = Typeface.createFromAsset(mContext.getAssets(),
                        "fonts/Today-Light.ttf");
                break;

            case TODAYE_TEXT_REGULAR:
                tf = Typeface.createFromAsset(mContext.getAssets(),
                        "fonts/Today-Regular.ttf");
                break;

            case TODAYE_TEXT_THIN:
                tf = Typeface.createFromAsset(mContext.getAssets(),
                        "fonts/Today-Thin.ttf");
                break;
            case TODAYE_TEXT_BOLD:
                tf = Typeface.createFromAsset(mContext.getAssets(),
                        "fonts/Today-Bold.ttf");
                break;
            case TODAYE_TEXT_BOLD_ITALIC:
                tf = Typeface.createFromAsset(mContext.getAssets(),
                        "fonts/Today-BoldItalic.ttf");
                break;
            case TODAYE_TEXT_LIGHT_ITALIC:
                tf = Typeface.createFromAsset(mContext.getAssets(),
                        "fonts/Today-LightItalic.ttf");
                break;
            default:
                tf = Typeface.createFromAsset(mContext.getAssets(),
                        "fonts/Today-Light.ttf");
                break;
        }
        this.setTypeface(tf, Typeface.NORMAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

