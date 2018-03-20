package com.bojue.homy.presenter.person;

import android.util.Log;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.model.person.IImageModel;
import com.bojue.homy.model.person.ImageModel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.Part;

/**
 * Created by Xie on 2018/3/11.
 */

public class ImagePresenter extends AbstractImagePresenter {
    private IImageModel mModel;

    public ImagePresenter() {
        mModel = new ImageModel();
    }

    @Override
    public void submitImage( List<MultipartBody.Part> partList) {
        mModel.submitImage(partList)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void onSuccess(String data) {
                        Log.i("TAG","on Sucess1111:");
                        getView().showImage(data);

                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        Log.i("TAG","on Fail22222:"+throwable.getMessage());
                    }
                });
    }
}
