package com.dgc.androidframe.test_net

import android.widget.Toast
import com.dgc.androidframe.utils.RuntimeContext
import com.dgc.framework.net.AbsApi
import com.dgc.framework.net.BaseObserver
import com.dgc.framework.net.NetworkUtil
import com.dgc.framework.net.RetrofitFactory
import io.reactivex.disposables.Disposable

/**
 * Created by Deng on 2019/1/22.
 */
class TestApi private constructor() : AbsApi() {
    private var mRetrofitService: ApiService

    init {
        BASE_URL = "http://yapi.demo.qunar.com/mock/14486/dgc/helloworld/"
        mRetrofitService = RetrofitFactory.instance.retrofit.create(ApiService::class.java)
    }

    private object Holder {
        val INSTANCE = TestApi()
    }

    override fun preExecute(disposable: Disposable) {
        if (!NetworkUtil.isNetworkAvailable(RuntimeContext.sApplicationContext)) {
            Toast.makeText(RuntimeContext.sApplicationContext, "网络连接异常，请检查网络", Toast.LENGTH_LONG).show()
            cancel()
        }
    }

    fun getUser(paramsMap: Map<String, Any>, observer: BaseObserver<TestBean>) {
        apiSubscribe(mRetrofitService.getUser(paramsMap), observer)
    }

    companion object {
        val instance = Holder.INSTANCE
    }
}
