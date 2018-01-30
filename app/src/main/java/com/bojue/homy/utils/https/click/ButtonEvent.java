package com.bojue.homy.utils.https.click;

import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

//import com.jakewharton.rxbinding.view.RxView;
//
//import java.util.concurrent.TimeUnit;
//
//import rx.Observer;

/**
 * Created by Administrator on 2018/1/26.
 * 防抖点击
 */

public class ButtonEvent {
    private OnFirstClickListener mFirstClickListener;
    private View mView;
    private ButtonEvent(OnFirstClickListener listener, final View view){
        this.mFirstClickListener=listener;
        this.mView=view;

    }

    public void registerClick(){
        RxView.clicks(mView)
                .throttleFirst(2, TimeUnit.SECONDS)//防抖点击2秒
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        if (mFirstClickListener!=null)
                            mFirstClickListener.onClick(mView);
                    }
                });
    }

    public static class Builder{
        private OnFirstClickListener mListener;
        private View mView;

        public Builder setOnClickListener(OnFirstClickListener listener){
            this.mListener=listener;
            return this;
        }
        public Builder setView(View view){
            this.mView=view;
            return this;
        }
        public ButtonEvent build(){
            return new ButtonEvent(mListener,mView);
        }
    }

    public interface OnFirstClickListener{
        void onClick(View view);
    }
}
