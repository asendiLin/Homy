package com.bojue.homy.utils.https.load;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bojue.homy.R;


/**
 * Created by lizheng on 2018/3/10.
 * 加载圆环
 */

public class LoadingDialog extends Dialog {
    private TextView textView;
    public LoadingDialog(@NonNull Context context) {
        super(context,R.style.LoadingDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);
        textView = findViewById(R.id.textview);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.dialog_loading);
        textView.startAnimation(animation);
        setCanceledOnTouchOutside(false);


    }

}
