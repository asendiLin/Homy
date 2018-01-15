package com.bojue.homy.view.fragment.publish;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.presenter.publish.AbstractPublishPresenter;
import com.bojue.homy.presenter.publish.PublishTextPre;

import static com.bojue.homy.utils.https.date.DateUtil.getSystemDate;

/**
 * Created by Administrator on 2018/1/6.
 * 发布Fragment
 */

public class PublishFragment extends BaseFragment implements IPublishView,View.OnClickListener{
    private Spinner spinner;
    private Button bt_publish;
    private View view;
    private TextView tv_data;
    private EditText et_number_publish;
    private EditText et_money_publish;
    private EditText et_need_content;
    private String[] mItems;
    private String needType;
    private String startTime;
    private String endTime;
    private int uId =1;
    private AbstractPublishPresenter mPresenter;
    private String price;
    private String phoneNum;
    private String needContent;
    private String latitude;
    private String longitude;
    private AlertDialog.Builder dialog;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_publish,container,false);
        spinner=  view.findViewById(R.id.sp_publish);
        tv_data = view.findViewById(R.id.tv_date);
        et_money_publish = view.findViewById(R.id.et_money_publish);
        et_number_publish = view.findViewById(R.id.et_number_publish);
        et_need_content = view.findViewById(R.id.et_need_content);
        bt_publish = view.findViewById(R.id.bt_publish);

        return view;
    }


    public void initData() {
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

        bt_publish.setOnClickListener(this);




//        mPresenter = new PublishPresenter();
        mPresenter = new PublishTextPre();
        mPresenter.attachView(this);

        //获取当前时间
        startTime = getSystemDate();

    }

    //监听事件回调
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_publish:
                price = et_money_publish.getText().toString();
                phoneNum = et_number_publish.getText().toString();
                endTime = tv_data.getText().toString();
                needContent = et_need_content.getText().toString();
                if(TextUtils.isEmpty(price)||TextUtils.isEmpty(phoneNum)||TextUtils.isEmpty(needContent)){
                    Toast.makeText(getContext(),"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }else if(phoneNum.length() != 11) {
                    et_number_publish.setError("请输入正确的手机号码");
                }else {
                    mPresenter.submitPublishContent(uId, price, phoneNum, needType, startTime, endTime, needContent, latitude, longitude);
                }
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
    //发布需求成功的回调

    @Override
    public void publishSuccess() {
        Log.d("money",price);
        Log.d("phoneNum",phoneNum);
        Log.d("startTime",startTime);
        dialog = new AlertDialog.Builder(getContext())
                .setTitle("发布成功")
                .setMessage("你的需求已经提交，快去看看有没有人接单吧！")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        et_money_publish.setText("");
                        et_need_content.setText("");
                        et_number_publish.setText("");
                    }
                });
        dialog.show();

    }
    //发布需求失败的回调
    @Override
    public void publishFail() {

    }



    /**
     * Created by Administrator on 2018/1/6.
     * 重写spinner的监听器
     */
    private class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //设置点击事件
          //  Toast.makeText(getContext(),mItems[i],Toast.LENGTH_SHORT).show();
            needType = (String) spinner.getItemAtPosition(i);
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
