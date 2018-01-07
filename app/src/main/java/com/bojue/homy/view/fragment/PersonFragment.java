package com.bojue.homy.view.fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.view.IView;

/**
 * Created by Administrator on 2018/1/6.
 * 个人Fragment
 */

public class PersonFragment extends BaseFragment implements IView {
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(),R.layout.person_fragment,null);
        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
}
