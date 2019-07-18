package com.dgc.androidframe.test_net

import com.dgc.framework.net.NormalResult
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.QueryMap

interface ApiService {
    //    @FormUrlEncoded
    //    @POST("R/MemberCardInformation.aspx")
    //    Observable<BaseEntity<VipModel>> getUser(@FieldMap Map<String, String> map);

    @GET("getUserInfo")
    fun getUser(@QueryMap map: HashMap<String, Any>): Observable<NormalResult<UserBean>>

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
    fun uploadImage(
        @Part("fileName") description: String,
        @Part("file\"; filename=\"image.png\"") imgs: RequestBody,
        @Part("file\"; filename=\"image.png\"") imgs1: RequestBody,
        @Part("file\"; filename=\"image.png\"") imgs3: RequestBody
    ): Call<String>
}
