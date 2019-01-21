package com.dgc.androidframe.base.net;

import com.dgc.androidframe.test_net.Api;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {
    private final static int TIME_OUT = 30;
    private static RetrofitService retrofitService;


    public static RetrofitService getService() {
        if (null == retrofitService) {
            synchronized (RetrofitFactory.class) {
                new RetrofitFactory();
            }
        }

        return retrofitService;
    }

    private RetrofitFactory() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain c) throws IOException {
                        Request.Builder builder = c.request().newBuilder();
//                    builder.addHeader("token", "abc");
                        return c.proceed(builder.build());
                    }
                }).connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        retrofitService = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
                .create(RetrofitService.class);

    }
}
