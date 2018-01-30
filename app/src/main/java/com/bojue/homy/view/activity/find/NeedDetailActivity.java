package com.bojue.homy.view.activity.find;

import android.os.Bundle;
import android.view.View;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.NeedDetailBean;
//需求详情Activity
public class NeedDetailActivity extends BaseActivity implements INeedDetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_detail);
    }

    /**
     * 显示需求详情
     * @param needDetailBean
     */
    @Override
    public void showNeedDetail(NeedDetailBean needDetailBean) {

    }

    /**
     * 接单结果
     * @param isSuccess
     */
    @Override
    public void showAcceptResult(boolean isSuccess) {

    }

    /**
     * 接单
     * @param view
     */
    public void onAccept(View view) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
}
