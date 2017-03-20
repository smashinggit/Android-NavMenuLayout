package com.git.navmenu;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.git.navmenulayout.R;


/**
 * author: chensen
 * date: 2017年03月17日10:19
 * desc:
 */

public class MenuItem extends FrameLayout {

    private int mIconWidth, mIconHeight;//图片大小
    private int mIconRes = 0;//图片资源
    private int mIconResSelected = 0;//选中图片资源

    private int mTextColor = Color.GRAY;//未选中的颜色(默认灰色)
    private int mTextColorSelected = Color.parseColor("#db4f55");//选中的颜色(默认红色)
    private int mTextSize = 12;//字体大小
    private String mText = "";//文字


    private View mRootView;
    private ImageView ivIcon;//图标
    private TextView tvText;//文字
    private TextView tvUnReadNum;//未读
    private TextView tvRedPoiont;//红点

    private boolean isSelected = false;//是否选中
    private int marginTop = 0;//文字和图标的距离


    public MenuItem(Context context) {
        this(context, null);
    }

    public MenuItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intiView(context);
    }

    private void intiView(Context context) {
        marginTop = PixelUtil.dpToPx(context, 5);
        //加载布局
        mRootView = LayoutInflater.from(context).inflate(R.layout.item_menu, this, false);

        ivIcon = (ImageView) mRootView.findViewById(R.id.iv_icon);
        tvText = (TextView) mRootView.findViewById(R.id.tv_text);
        tvUnReadNum = (TextView) mRootView.findViewById(R.id.tv_unred_num);
        tvRedPoiont = (TextView) mRootView.findViewById(R.id.tv_point);
        addView(mRootView);
    }

    /**
     * 刷新状态
     */
    private void refreshState() {
        if (isSelected) {
            if (mIconResSelected != 0 && mTextColorSelected != 0) {
                ivIcon.setImageResource(mIconResSelected);
                tvText.setTextColor(mTextColorSelected);
            }

        } else {
            if (mIconRes != 0 && mIconResSelected != 0) {
                ivIcon.setImageResource(mIconRes);
                tvText.setTextColor(mTextColor);
            }
        }
        if (mTextSize > 0) {
            tvText.setTextSize(mTextSize);
        }
        tvText.setText(mText);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tvText.getLayoutParams();
        layoutParams.topMargin = marginTop;
        tvText.setLayoutParams(layoutParams);
    }

    /**
     * 设置选中状态
     *
     * @param isSelected
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        refreshState();
    }


    /**
     * 设置图标
     *
     * @param res
     */
    public void setIcon(@DrawableRes int res) {
        this.mIconRes = res;
    }

    /**
     * 设置选中图标
     *
     * @param res
     */
    public void setIconSelected(@DrawableRes int res) {
        this.mIconResSelected = res;
    }

    /**
     * 设置图标大小
     *
     * @param width
     * @param height
     */
    public void setIconSize(int width, int height) {
        this.mIconWidth = width;
        this.mIconHeight = height;
        LayoutParams params = (LayoutParams) ivIcon.getLayoutParams();
        params.width = mIconWidth;
        params.height = mIconHeight;
        ivIcon.setLayoutParams(params);
    }


    /**
     * 设置文字
     *
     * @param text
     */
    public void setText(String text) {
        this.mText = text;
    }

    /**
     * 设置文字大小
     *
     * @param size
     */
    public void setTextSize(int size) {
        this.mTextSize = size;
    }

    /**
     * 文字颜色
     *
     * @param color
     */

    public void setTextColor(int color) {
        this.mTextColor = color;
    }


    /**
     * 选中的文字颜色
     *
     * @param color
     */
    public void setSelectedTextColor(int color) {
        this.mTextColorSelected = color;
    }


    /**
     * 显示提示
     *
     * @param msg
     */
    public void setMsg(String msg) {
        tvUnReadNum.setVisibility(VISIBLE);
        tvUnReadNum.setText(msg);
        tvRedPoiont.setVisibility(GONE);
    }

    /**
     * 图标和文字之间的距离
     *
     * @param marginTop
     */
    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }


    /**
     * 隐藏提示
     */
    public void hideMsg() {
        tvUnReadNum.setVisibility(GONE);
    }

    /**
     * 显示红点
     *
     * @param isShow
     */
    public void showRedPoint(boolean isShow) {
        tvRedPoiont.setVisibility(VISIBLE);
        tvUnReadNum.setVisibility(GONE);
    }

    /**
     * 隐藏红点
     */

    public void hideRedPoint() {
        tvRedPoiont.setVisibility(GONE);
    }

    /**
     * 隐藏所有提示
     */
    public void hideAllTips() {
        tvRedPoiont.setVisibility(GONE);
        tvUnReadNum.setVisibility(GONE);
    }


    /**
     * 获取是否选中
     *
     * @return
     */
    public boolean getIsSelected() {
        return isSelected;
    }


}
