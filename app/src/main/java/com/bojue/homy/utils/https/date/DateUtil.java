package com.bojue.homy.utils.https.date;

import java.text.SimpleDateFormat;

/**
 * Created by lizheng on 2018/1/12.
 * 获取系统时间的工具类
 */

public class DateUtil {

    /**
     * 通过System类中的currentTimeMillis方法来获取当前时间
     */
    public static String getSystemDate(){
        String mDate;
        SimpleDateFormat mDateFormat = new SimpleDateFormat("今天 HH : mm");
        mDate = mDateFormat.format(System.currentTimeMillis());
        return mDate;
    }
}
