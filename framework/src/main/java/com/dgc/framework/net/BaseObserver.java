package com.dgc.framework.net;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseBean<T>> {
    private static final String TAG = "BaseObserver";

    private Context mContext;
    private static final int SUCCESS_CODE = 0;

    public BaseObserver(Context context) {
        mContext = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(BaseBean<T> value) {
        if (value.getCode() == SUCCESS_CODE) {
            T t = value.getBody();
            onSuccess(t);
        } else {
            onError(value.getCode(), value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "error:" + e.toString());

        Toast.makeText(mContext, "网络异常，请稍后再试", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete() {
        Log.i(TAG, "onComplete");
    }

    public abstract void onSuccess(T t);

    public void onError(int code, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
}
