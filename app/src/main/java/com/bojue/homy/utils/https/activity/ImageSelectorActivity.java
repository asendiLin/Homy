package com.bojue.homy.utils.https.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;

import me.nereo.multi_image_selector.MultiImageSelector;


/**
 * Created by Xie on 2018/3/13.
 */

public class ImageSelectorActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_image;
    private static final int mRequestCode = 66;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        btn_image = findViewById(R.id.btn_image);
        btn_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MultiImageSelector.create(this)
                .showCamera(true)
                .count(1)
                .start(this,mRequestCode);

    }
}
