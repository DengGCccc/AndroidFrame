package com.dgc.androidframe.test_net;

import android.widget.Toast;

import com.dgc.androidframe.base.net.BaseBean;
import com.dgc.androidframe.base.net.BaseObserver;
import com.dgc.androidframe.base.net.NetworkUtil;
import com.dgc.androidframe.base.net.RetrofitFactory;
import com.dgc.androidframe.utils.MyApplication;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Deng on 2018/7/26.
 */
public class Api {
    public static final String BASE_URL = "http://yapi.demo.qunar.com/mock/14486/dgc/helloworld/";


    /**
     * 封装线程管理和订阅的过程
     */
    private static <T> void apiSubscribe(Observable<BaseBean<T>> observable, BaseObserver observer) {
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


    public static void getUser(BaseObserver observer, Map<String, Object> paramsMap) {
        apiSubscribe(RetrofitFactory.getService().getUser(paramsMap), observer);
    }


}
