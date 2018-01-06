package com.bojue.homy.view.fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/6.
 * 发布Fragment
 */

public class PublishFragment extends BaseFragment {
    private Spinner spinner;
    private View view;
    private TextView tv_data;
    private String[] mItems;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.publish_fragment,container,false);
        spinner=  view.findViewById(R.id.sp_publish);
        tv_data = view.findViewById(R.id.tv_date);
//        String[] mItems ={"跑腿","代购","代课"};
        mItems =getResources().getStringArray(R.array.need_type_arr);
        //设置spinner的适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        //设置spinner的监听
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
        //设置TextView的监听
        tv_data.setOnClickListener(new MyOnContextClickListener() );
        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    /**
     * Created by Administrator on 2018/1/6.
     * 重写spinner的监听器
     */
    private class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //设置点击事件
            Toast.makeText(getContext(),mItems[i],Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
    /**
     * Created by Administrator on 2018/1/6.
     * 重写TextView的监听器
     */
    private class MyOnContextClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //结束时间的点击事件内容
            Toast.makeText(getContext(),"1.2",Toast.LENGTH_SHORT).show();
        }
    }
}
