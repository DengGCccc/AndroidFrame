package com.dgc.framework.base

import com.dgc.framework.mvp.IMvpPresenter
import com.dgc.framework.mvp.IMvpView

/**
 * Created by Deng on 2018/7/25.
 */
open class BasePresenter<V : IMvpView> : IMvpPresenter<V> {
    /**
     * 绑定的view
     */
    var view: V? = null

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    override fun attachView(mvpView: V) {
        this.view = mvpView
    }

    /**
     * 断开view，已在BaseActivity onDestroy中调用
     */
    override fun detachView() {
        this.view = null
    }
}
