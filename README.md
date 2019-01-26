# AndroidFrame

* 网络框架 Retrofit2 + Rxjava2

```
public class MyApi extends BaseApi {

    private static ApiService mRetrofitService;

    public static MyApi getInstance() {
        return Holder.INSTANCE;
    }

    private MyApi() {
        BASE_URL = "http://yapi.demo.qunar.com/mock/14486/dgc/helloworld/";
        mRetrofitService = RetrofitFactory.getInstance().getRetrofit().create(ApiService.class);
    }

    private static class Holder {
        private static MyApi INSTANCE = new MyApi();
    }

    public void getUser(Map<String, Object> paramsMap, BaseObserver observer) {
        apiSubscribe(mRetrofitService.getUser(paramsMap), observer);
    }
}
```

```
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
```

```
MyApi.getInstance().getUser(map, new BaseObserver<TestBean>(this) {
    @Override
    public void onSuccess(TestBean testBean) {

        ((TextView) findViewById(R.id.tv_result)).setText(testBean.getAge() + "=====" + testBean.getName());
    }
});
```

