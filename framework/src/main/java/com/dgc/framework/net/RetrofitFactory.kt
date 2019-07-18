package com.dgc.framework.net

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitFactory private constructor() {

    val retrofit: Retrofit

    private object Holder {
        val INSTANCE = RetrofitFactory()
    }

    init {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor { c ->
                val builder = c.request().newBuilder()
//                builder.header("token", "abc")
                c.proceed(builder.build())
            }.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BaseApi.BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }

    companion object {
        const val TIME_OUT = 10

        val instance = Holder.INSTANCE
    }
}
