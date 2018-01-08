package com.bojue.homy.view.fragment.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.entity.NeedItem;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 * 个人Fragment
 */

public class PersonFragment extends BaseFragment {

    private View mView;
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        mView = View.inflate(getContext(),R.layout.fragement_person,null);
        return mView;
    }
}
