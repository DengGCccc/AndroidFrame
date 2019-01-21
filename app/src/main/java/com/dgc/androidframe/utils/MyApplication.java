package com.dgc.androidframe.utils;

import android.app.Application;

/**
 * Created by Deng on 2018/7/26.
 */
public class MyApplication extends Application {

    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }
}
