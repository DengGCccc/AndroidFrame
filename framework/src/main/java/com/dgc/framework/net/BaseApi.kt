package com.dgc.framework.net

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Deng on 2018/7/26.
 */
abstract class BaseApi {
    private var mDisposable: Disposable? = null

    /**
     * 封装线程管理和订阅的过程
     */
    protected fun <T> apiSubscribe(observable: Observable<NormalResult<T>>, observer: NormalObserver<T>) {
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
            .doOnSubscribe { disposable -> mDisposable = disposable }
            .subscribe(observer)
    }

    protected fun cancel() {
        mDisposable?.dispose()
    }

    protected abstract fun preExecute(disposable: Disposable)

    companion object {
        lateinit var BASE_URL: String
    }
}
