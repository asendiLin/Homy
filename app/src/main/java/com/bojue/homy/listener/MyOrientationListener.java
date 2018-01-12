package com.bojue.homy.listener;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by Administrator on 2018/1/12.
 */

public class MyOrientationListener implements SensorEventListener {


    private Context mContext;
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private OnOrientationListener mOnOrientationListener;
    private float lastX;

    public MyOrientationListener(Context context){
        this.mContext=context;
    }

    /**
     * 开始传感器
     */
    public void start(){
        mSensorManager= (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);

        if (mSensorManager!=null){
            //获取方向传感器
            mSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        }
        if (mSensor!=null){
            mSensorManager.registerListener(this,mSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }
    }

    /**
     * 停止
     */
    public void stop(){
        mSensorManager.unregisterListener(this);
    }

    public void setOnOrientationListener(OnOrientationListener onOrientationListener) {
        mOnOrientationListener = onOrientationListener;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //改变方向
        if (event.sensor.getType()==Sensor.TYPE_ORIENTATION){
            float x=event.values[SensorManager.DATA_X];

            if(Math.abs(x-lastX)>1.0){
                if (mOnOrientationListener!=null){
                    mOnOrientationListener.onOrientationChanged(x);
                }
            }
            lastX=x;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * 方向修改的监听器
     */
    public interface OnOrientationListener{
        void onOrientationChanged(float x);
    }
}
