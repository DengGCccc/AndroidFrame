package com.dgc.framework.net

import com.dgc.framework.utils.logger.AppLogger
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class NormalObserver<T> : Observer<NormalResult<T>> {

    override fun onSubscribe(d: Disposable) {}

    override fun onNext(result: NormalResult<T>) {
        if (result.code == SUCCESS_CODE) {
            val t = result.data
            onSuccess(t)
        } else {
            onError(result.code, result.msg)
        }
    }

    override fun onError(e: Throwable) {
        AppLogger.e(TAG, "error:$e")
        onError(UNKNOWN_ERROR, e.message)
    }

    override fun onComplete() {
        AppLogger.i(TAG, "onComplete")
    }

    abstract fun onSuccess(result: T?)

    fun onError(code: Int, message: String?) {
    }

    companion object {
        const val TAG = "NormalObserver"
        const val SUCCESS_CODE = 0
        const val UNKNOWN_ERROR = 9999
    }
}
