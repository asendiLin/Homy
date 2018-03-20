package com.bojue.homy.model.person;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.PersonBean;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.Part;

/**
 * Created by Xie on 2018/3/11.
 */

public interface IImageModel  {

    Observable<BaseEntity<String>> submitImage(List<MultipartBody.Part> partList);
}
