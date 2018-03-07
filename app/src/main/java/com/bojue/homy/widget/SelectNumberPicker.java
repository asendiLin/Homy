package com.bojue.homy.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/10/10.
 */

public class SelectNumberPicker extends NumberPicker {
    public SelectNumberPicker(Context context) {
        super(context);
    }

    public SelectNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addView(View child) {
        this.addView(child,null);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        this.addView(child,-1, params);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        setNumberPicker(child);
    }

    private void setNumberPicker(View child) {
        if (child instanceof EditText){
            ((EditText) child).setTextColor(Color.BLACK);
            ((EditText) child).setTextSize(18f);
        }
    }

    public static void setNumberPickerDividerColor(NumberPicker numberPicker){
        NumberPicker mNumberPicker=numberPicker;
        Field[] pickerFields=NumberPicker.class.getFields();
        //设置分割线的颜色
        for (Field pf: pickerFields) {
            if (pf.getName().equals("mSelectionDivider")){
                pf.setAccessible(true);
                try {
                    pf.set(mNumberPicker,new ColorDrawable(Color.parseColor("#FFC87472")));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        //设置分割线的高度
        for (Field pf: pickerFields) {
            if (pf.getName().equals("mSelectionDividerHeight")){
                pf.setAccessible(true);
                try {
                    int height=3;
                    pf.set(mNumberPicker,height);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }
}
