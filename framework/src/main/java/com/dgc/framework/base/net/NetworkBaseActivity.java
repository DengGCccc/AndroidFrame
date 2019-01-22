package com.dgc.framework.base.net;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.dgc.androidframe.utils.MyApplication;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NetworkBaseActivity extends AppCompatActivity {
    private final long RETRY_TIMES = 5;
    private Disposable mDisposable;


    public <T> ObservableTransformer<T, T> setThread() {

        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) {
                                mDisposable = disposable;
                                if (!NetworkUtil.isNetworkAvailable(MyApplication.app)) {
                                    System.out.println("=========");
                                    Toast.makeText(MyApplication.app, "网络连接异常，请检查网络", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (null != mDisposable)
            mDisposable.dispose();
    }
}
