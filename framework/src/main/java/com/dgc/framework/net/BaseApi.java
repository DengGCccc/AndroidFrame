package com.dgc.framework.net;

import android.widget.Toast;

import com.dgc.framework.net.BaseBean;
import com.dgc.framework.net.BaseObserver;
import com.dgc.framework.net.NetworkUtil;
import com.dgc.framework.net.RetrofitFactory;
import com.dgc.framework.MyApplication;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Deng on 2018/7/26.
 */
public class BaseApi {
    public static String BASE_URL;

    /**
     * 封装线程管理和订阅的过程
     */
    protected static <T> void apiSubscribe(Observable<BaseBean<T>> observable, BaseObserver observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) {
                        if (!NetworkUtil.isNetworkAvailable(MyApplication.app)) {
                            Toast.makeText(MyApplication.app, "网络连接异常，请检查网络", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .subscribe(observer);
    }



}
