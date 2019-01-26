package com.dgc.androidframe.test_net;


import com.dgc.framework.net.BaseBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

public interface ApiService {
//    @FormUrlEncoded
//    @POST("R/MemberCardInformation.aspx")
//    Observable<BaseEntity<VipModel>> getUser(@FieldMap Map<String, String> map);

    @GET("getUserInfo")
    Observable<BaseBean<TestBean>> getUser(@QueryMap Map<String, Object> map);


    /**
     * 上传三张图片
     * @param description
     * @param imgs
     * @param imgs1
     * @param imgs3
     * @return
     */
    @Multipart
    @POST("/upload")
    Call<String> uploadImage(@Part("fileName") String description,
                             @Part("file\"; filename=\"image.png\"") RequestBody imgs,
                             @Part("file\"; filename=\"image.png\"") RequestBody imgs1,
                             @Part("file\"; filename=\"image.png\"") RequestBody imgs3);
}
