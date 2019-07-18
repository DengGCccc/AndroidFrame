package com.dgc.framework.mvp

/**
 * Created by Deng on 2019-07-17.
 */
interface IMvpPresenter<V : IMvpView> {
    fun attachView(mvpView: V)
    fun detachView()
}