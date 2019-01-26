package com.dgc.androidframe.test_net;

import com.dgc.framework.net.BaseApi;
import com.dgc.framework.net.BaseObserver;
import com.dgc.framework.net.RetrofitFactory;

import java.util.Map;

/**
 * Created by Deng on 2019/1/22.
 */
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
