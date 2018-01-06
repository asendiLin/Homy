package com.bojue.homy.view.fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bojue.homy.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/6.
 */

public class SearchNeedFragment extends BaseFragment {
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        TextView textView=new TextView(getActivity());
        textView.setText("查看");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
