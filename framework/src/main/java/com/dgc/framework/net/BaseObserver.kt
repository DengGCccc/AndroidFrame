package com.dgc.framework.net

import android.content.Context
import android.util.Log
import android.widget.Toast

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class BaseObserver<T>(private val mContext: Context) : Observer<BaseBean<T>> {

    override fun onSubscribe(d: Disposable) {}

    override fun onNext(value: BaseBean<T>) {
        if (value.code == SUCCESS_CODE) {
            val t = value.body
            onSuccess(t)
        } else {
            onError(value.code, value.msg)
        }
    }

    override fun onError(e: Throwable) {
        Log.e(TAG, "error:$e")

        Toast.makeText(mContext, "网络异常，请稍后再试", Toast.LENGTH_LONG).show()
    }

    override fun onComplete() {
        Log.i(TAG, "onComplete")
    }

    abstract fun onSuccess(t: T?)

    fun onError(code: Int, message: String?) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val TAG = "BaseObserver"
        const val SUCCESS_CODE = 0
    }
}
