package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import io.reactivex.Observable;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by Xie on 2018/3/11.
 */

public interface ImageService {

    @Multipart
    @POST("hemy/user/updateUploadImg")
    Observable<BaseEntity<String>> submitImage(@Part List<MultipartBody.Part> partList);
}
