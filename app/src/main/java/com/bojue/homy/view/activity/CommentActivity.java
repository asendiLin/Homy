package com.bojue.homy.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;

public class CommentActivity extends BaseActivity implements CommentView,View.OnClickListener {
    private ImageButton ib_back_community;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ib_back_community = findViewById(R.id.ib_back_community);
        ib_back_community.setVisibility(View.VISIBLE);
        ib_back_community.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
}
