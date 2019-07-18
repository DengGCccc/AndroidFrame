package com.dgc.androidframe.test_net

import com.dgc.framework.base.BasePresenter
import com.dgc.framework.net.Callback

/**
 * Created by Deng on 2018/7/25.
 */
class NetPresenter : BasePresenter<NetView>() {

    private var mModel: NetModel = NetModel()

    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    fun getUserInfo() {
        view?.showLoading()

        mModel.getUserInfo(object : Callback<UserBean> {
            override fun onSuccess(data: UserBean?) {
                view?.showData(data?.name + "====" + data?.age)
            }

            override fun onComplete() {
                super.onComplete()
                view?.hideLoading()
            }
        })
    }
}