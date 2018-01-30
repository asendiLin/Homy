package com.bojue.homy.view.activity;

import android.os.Bundle;
import android.view.View;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;

public class ChatActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    /**
     * 发送消息
     * @param view
     */
    public void onSend(View view) {
    }
}
