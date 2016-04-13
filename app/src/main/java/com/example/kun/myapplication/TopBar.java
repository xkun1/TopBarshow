package com.example.kun.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kun.myapplication.R;

/**
 * 创建TopBar继承RelativeLayout
 */
public class TopBar extends RelativeLayout {

    private Button mLeftButton,mRightButton;

    private TextView mTextview;

    private String mLeftTitle;
    private int mLeftTitleColor;
    private Drawable mLeftButtonBackGround;
    private float mLeftTitleSize;

    private String mRightTitle;
    private int mRightTitleColor;
    private Drawable mRightButtonBackGround;
    private float mRightTitleSize;

    private String mTextviewTitle;
    private int mTextviewColor;
    private float mTextviewSize;


    private LayoutParams leftParams,rightParams,textviewParams;

    private topBarClickLister topBarClickLister;

    public interface topBarClickLister{
        void leftClick();
        void rightClick();
    }


    protected void setClickLister(topBarClickLister lister){
        this.topBarClickLister=lister;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        mLeftTitle=typedArray.getString(R.styleable.TopBar_LeftButtonTitle);
        mLeftTitleColor=typedArray.getColor(R.styleable.TopBar_LeftTitleColor,Color.BLACK);
        mLeftButtonBackGround=typedArray.getDrawable(R.styleable.TopBar_LeftBackGround);
        mLeftTitleSize=typedArray.getDimensionPixelSize(R.styleable.TopBar_LeftTitleSize,16);

        mRightTitle=typedArray.getString(R.styleable.TopBar_RightButtonTitle);
        mRightTitleSize=typedArray.getDimensionPixelSize(R.styleable.TopBar_RightTitleSize,16);
        mRightTitleColor=typedArray.getColor(R.styleable.TopBar_RightTitleColor,Color.BLACK);
        mRightButtonBackGround=typedArray.getDrawable(R.styleable.TopBar_RightBackGround);

        mTextviewTitle=typedArray.getString(R.styleable.TopBar_Title);
        mTextviewColor=typedArray.getColor(R.styleable.TopBar_TitleColor, Color.BLACK);
        mTextviewSize=typedArray.getDimensionPixelSize(R.styleable.TopBar_TitleSize,32);

        typedArray.recycle();

        mTextview=new TextView(context);
        mLeftButton=new Button(context);
        mRightButton=new Button(context);

        mLeftButton.setText(mLeftTitle);
        mLeftButton.setBackground(mLeftButtonBackGround);
        mLeftButton.setTextColor(mLeftTitleColor);
        mLeftButton.setTextSize(mLeftTitleSize);

        mRightButton.setText(mRightTitle);
        mRightButton.setBackground(mRightButtonBackGround);
        mRightButton.setTextColor(mRightTitleColor);
        mRightButton.setTextSize(mRightTitleSize);

        mTextview.setTextSize(mTextviewSize);
        mTextview.setText(mTextviewTitle);
        mTextview.setTextColor(mTextviewColor);
        mTextview.setGravity(Gravity.CENTER);

        leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,leftParams);

        rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,rightParams);

        textviewParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textviewParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTextview,textviewParams);


        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topBarClickLister.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topBarClickLister.rightClick();
            }
        });

    }
}
