package com.bojue.homy.presenter.person;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.activity.person.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.Part;

/**
 * Created by Xie on 2018/3/11.
 */

public abstract class AbstractImagePresenter extends BasePresenter<ImageView> {

    public abstract void submitImage(List<MultipartBody.Part> partList);
}
