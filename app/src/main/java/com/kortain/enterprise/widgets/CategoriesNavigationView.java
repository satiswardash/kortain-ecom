package com.kortain.enterprise.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;

/**
 * Created by satiswardash on 06/12/17.
 */

public class CategoriesNavigationView extends NavigationView {


    public CategoriesNavigationView(Context context) {
        super(context);
    }

    public CategoriesNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoriesNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable savedState) {
        super.onRestoreInstanceState(savedState);
    }

    @Override
    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener listener) {
        super.setNavigationItemSelectedListener(listener);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
    }

    @Override
    public void inflateMenu(int resId) {
        super.inflateMenu(resId);
    }

    @Override
    public Menu getMenu() {
        return super.getMenu();
    }

    @Override
    public View inflateHeaderView(int res) {
        return super.inflateHeaderView(res);
    }

    @Override
    public void addHeaderView(@NonNull View view) {
        super.addHeaderView(view);
    }

    @Override
    public void removeHeaderView(@NonNull View view) {
        super.removeHeaderView(view);
    }

    @Override
    public int getHeaderCount() {
        return super.getHeaderCount();
    }

    @Override
    public View getHeaderView(int index) {
        return super.getHeaderView(index);
    }

    @Nullable
    @Override
    public ColorStateList getItemIconTintList() {
        return super.getItemIconTintList();
    }

    @Override
    public void setItemIconTintList(@Nullable ColorStateList tint) {
        super.setItemIconTintList(tint);
    }

    @Nullable
    @Override
    public ColorStateList getItemTextColor() {
        return super.getItemTextColor();
    }

    @Override
    public void setItemTextColor(@Nullable ColorStateList textColor) {
        super.setItemTextColor(textColor);
    }

    @Nullable
    @Override
    public Drawable getItemBackground() {
        return super.getItemBackground();
    }

    @Override
    public void setItemBackgroundResource(int resId) {
        super.setItemBackgroundResource(resId);
    }

    @Override
    public void setItemBackground(@Nullable Drawable itemBackground) {
        super.setItemBackground(itemBackground);
    }

    @Override
    public void setCheckedItem(int id) {
        super.setCheckedItem(id);
    }

    @Override
    public void setItemTextAppearance(int resId) {
        super.setItemTextAppearance(resId);
    }
}
