package com.bojue.homy.utils.https.activity;

import com.bojue.homy.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 * 控制的容器
 */

public class ActivityController {

    private static List<BaseActivity> mBaseActivities=new ArrayList<>();

    public static void addActivty(BaseActivity activity){
        mBaseActivities.add(activity);
    }

    public static void removeActivty(BaseActivity activity){
        mBaseActivities.remove(activity);
    }

    public static void clearActivty(){
        for (BaseActivity activity: mBaseActivities) {
            activity.finish();
        }
        mBaseActivities.clear();
    }

}
