package com.dgc.androidframe.test_activity

import com.dgc.framework.base.BasePresenter
import com.dgc.framework.net.Callback

/**
 * Created by Deng on 2018/7/25.
 */
class TestPresenter : BasePresenter<TestView>() {
    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    fun getData(params: String) {
        view?.showLoading()

        TestModel.getNetData(params, object : Callback<String> {
            override fun onSuccess(data: String) {
                view?.showData(data)
            }

            override fun onFailure(msg: String) {
                view?.showToast(msg)
            }

            override fun onComplete() {
                view?.hideLoading()
            }
        })
    }
}