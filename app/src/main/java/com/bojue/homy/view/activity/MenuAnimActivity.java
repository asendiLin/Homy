package com.bojue.homy.view.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bojue.homy.R;

public class MenuAnimActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    private Button mMenuButton;
    private Button mItemButton1;
    private Button mItemButton2;
    private Button mItemButton3;
    private Button mItemButton4;
    private Button mItemButton5;

    private boolean mIsMenuOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_anim);
        initView();
    }

    private void initView() {
        mMenuButton = (Button) findViewById(R.id.menu);
        mMenuButton.setOnClickListener(this);

        mItemButton1 = (Button) findViewById(R.id.item1);
        mItemButton1.setOnClickListener(this);

        mItemButton2 = (Button) findViewById(R.id.item2);
        mItemButton2.setOnClickListener(this);

        mItemButton3 = (Button) findViewById(R.id.item3);
        mItemButton3.setOnClickListener(this);

        mItemButton4 = (Button) findViewById(R.id.item4);
        mItemButton4.setOnClickListener(this);

        mItemButton5 = (Button) findViewById(R.id.item5);
        mItemButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mMenuButton) {
            if (!mIsMenuOpen) {
                mIsMenuOpen = true;
                doAnimateOpen(mItemButton1, 0, 5, 600);
                doAnimateOpen(mItemButton2, 1, 5, 600);
                doAnimateOpen(mItemButton3, 2, 5, 600);
                doAnimateOpen(mItemButton4, 3, 5, 600);
                doAnimateOpen(mItemButton5, 4, 5, 600);
            } else {
                mIsMenuOpen = false;
                doAnimateClose(mItemButton1, 0, 5, 600);
                doAnimateClose(mItemButton2, 1, 5, 600);
                doAnimateClose(mItemButton3, 2, 5, 600);
                doAnimateClose(mItemButton4, 3, 5, 600);
                doAnimateClose(mItemButton5, 4, 5, 600);
            }
        } else {
            Toast.makeText(this, "你点击了" + view, Toast.LENGTH_SHORT).show();
        }
    }
    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90)/(total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));

        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        //动画周期为500ms
        set.setDuration(1 * 500).start();
    }
    private void doAnimateClose(final View view, int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0.1f));

        set.setDuration(1 * 500).start();
    }
}
