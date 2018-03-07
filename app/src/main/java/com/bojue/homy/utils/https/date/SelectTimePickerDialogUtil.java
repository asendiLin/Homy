package com.bojue.homy.utils.https.date;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.widget.SelectNumberPicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/10.
 */

public class SelectTimePickerDialogUtil implements NumberPicker.OnValueChangeListener, View.OnClickListener {

    private TextView selectedTime;
    private SelectNumberPicker datePicker;
    private SelectNumberPicker hourPicker;
    private SelectNumberPicker minutePicker;
    private int mDate;
    private int mHour;
    private int mMinute;
    private String[] dateArr;
    private String[] hourArr;
    private String[] minuteArr;
    private String selectedTimeStr;
    private String showSelectedTimeStr;
    private Context mContext;
    private Dialog mDialog;
    private OnSelectedTimeListener mListener;

    private SelectTimePickerDialogUtil(Builder builder) {
        this.mContext = builder.context;
        this.selectedTime = builder.selectedTime;
        this.dateArr = builder.dateArr;
        this.hourArr = builder.hourArr;
        this.minuteArr = builder.minuteArr;
        this.mListener = builder.mListener;
    }

    /**
     * 初始化时间选择器
     */
    private void initPicker() {
        Calendar calendar = Calendar.getInstance();

        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        if (minute >= 45)
            minute = 0;
        else if (minute >= 30)
            minute = 3;
        else if (minute >= 15)
            minute = 2;
        else
            minute = 1;

        //日期
        if (dateArr == null) {
            dateArr = new String[]{"今天", "明天", "后天"};
        }
//天
        datePicker.setOnValueChangedListener(this);
        datePicker.setDisplayedValues(dateArr);
        datePicker.setMinValue(0);
        datePicker.setMaxValue(dateArr.length - 1);
        datePicker.setValue(0);
        mDate=0;
//时
        hourPicker.setOnValueChangedListener(this);
        hourPicker.setMinValue(0);
        hourPicker.setMaxValue(23);
        if (minute == 0) {
            hourPicker.setValue(hours + 1);
            mHour = hours + 1 ;
        } else {
            hourPicker.setValue(hours);
            mHour = hours;
        }
//分钟
        if (minuteArr == null) {
            minuteArr = new String[]{"00", "15", "30", "45"};
        }
        minutePicker.setOnValueChangedListener(this);
        minutePicker.setDisplayedValues(minuteArr);
        minutePicker.setMinValue(0);
        minutePicker.setMaxValue(minuteArr.length - 1);
        minutePicker.setValue(minute);
        mMinute= Integer.parseInt(minuteArr[minute]);
    }

    public void showSelectDialog() {
        View selectView = View.inflate(mContext, R.layout.select_time_picker_layout, null);
        selectView.findViewById(R.id.tv_confirm).setOnClickListener(this);
        selectView.findViewById(R.id.tv_cancel).setOnClickListener(this);
        datePicker =selectView.findViewById(R.id.snp_date);
        hourPicker =selectView.findViewById(R.id.snp_hour);
        minutePicker =selectView.findViewById(R.id.snp_minute);
        //滑动时屏蔽键盘
        datePicker.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        hourPicker.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        minutePicker.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        //分割线颜色
        datePicker.setNumberPickerDividerColor(datePicker);
        hourPicker.setNumberPickerDividerColor(hourPicker);
        minutePicker.setNumberPickerDividerColor(minutePicker);

        initPicker();

        mDialog = new Dialog(mContext,R.style.dialog_bottom_filter);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(selectView,
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Window window = mDialog.getWindow();
//        window.setWindowAnimations(R.style);
        WindowManager.LayoutParams wl = window.getAttributes();

        wl.y = ((Activity) mContext).getWindowManager().getDefaultDisplay().getHeight();
        wl.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        wl.height = RelativeLayout.LayoutParams.WRAP_CONTENT;

        mDialog.onWindowAttributesChanged(wl);
        mDialog.setCanceledOnTouchOutside(true);

        mDialog.show();

        onDateChanged();
    }

    /**
     * 数据改变
     */
    private void onDateChanged() {
        Date date=new Date();
        int day=date.getDate()+mDate;
        date.setDate(day);
        date.setHours(mHour);
        date.setMinutes(mMinute);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd:HH:mm");
        selectedTimeStr=sdf.format(date);
        showSelectedTimeStr=dateArr[mDate]+"  "+mHour+" : "+mMinute;
        if (mMinute==0){
            //为了显示一致
            showSelectedTimeStr += "0";
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_confirm:
                if (mListener!=null)
                    mListener.onSelectedTime(selectedTimeStr,mDialog,showSelectedTimeStr);
                break;
            case R.id.tv_cancel:
                mDialog.dismiss();
                break;
        }
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        switch (picker.getId()) {
            case R.id.snp_date:
                mDate=newVal;
                break;
            case R.id.snp_hour:
                mHour=newVal;
                break;
            case R.id.snp_minute:
                mMinute= Integer.parseInt(minuteArr[newVal]);
                break;
        }
        onDateChanged();
    }

    public interface OnSelectedTimeListener {
        void onSelectedTime(String selectedTime, Dialog dialog, String showSelectedTimeStr);
    }

    public static class Builder {
        private final Context context;
        private TextView selectedTime;
        private String[] dateArr;
        private String[] hourArr;
        private String[] minuteArr;
        private OnSelectedTimeListener mListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setDateArr(String[] dateArr) {
            this.dateArr = dateArr;
            return this;
        }

        public Builder setHourArr(String[] hourArr) {
            this.hourArr = hourArr;
            return this;
        }

        public Builder setMuniteArr(String[] minuteArr) {
            this.minuteArr = minuteArr;
            return this;
        }

        public Builder setSelecteTimeView(TextView view) {
            this.selectedTime = view;
            return this;
        }

        public Builder setOnSelectedTimeListener(OnSelectedTimeListener listener) {
            this.mListener = listener;
            return this;
        }

        public SelectTimePickerDialogUtil build() {
            return new SelectTimePickerDialogUtil(this);
        }
    }
}
