package com.huxq17.example.floatball;

import android.content.Context;
import android.widget.RelativeLayout;

import com.huxq17.example.floatball.arcmenu.ArcMenu;
import com.huxq17.example.floatball.interfaces.IMenu;

/**
 * Created by huangxiquan on 17/1/17.
 */

public class FloatBallArcMenu implements IMenu {


    private int menuWidth, menuHeight;

    @Override
    public void onAttach(FloatBall floatBall, Context context) {
        menuWidth = DensityUtil.dip2px(context, 135);
        menuHeight = DensityUtil.dip2px(context, 30);
    }

    @Override
    public void addMenu(RelativeLayout parent) {
        ArcMenu arcMenu = new ArcMenu(parent.getContext());
    }

    @Override
    public boolean isRightMenuEnable() {
        return false;
    }

    @Override
    public boolean isLeftMenuEnable() {
        return false;
    }

    @Override
    public void showingRightMenu() {

    }

    @Override
    public void showingLeftMenu() {

    }

    @Override
    public int getMenuHeight() {
        return menuHeight;
    }

    @Override
    public int getMenuWidth() {
        return menuWidth;
    }
}
