package com.dgc.framework.mvp

/**
 * Created by Deng on 2018/7/25.
 */
interface IMvpView {

    /**
     * 显示正在加载进度条
     */
    fun showLoading()

    /**
     * 关闭正在加载进度条
     */
    fun hideLoading()

    /**
     * Toast提示
     *
     * @param msg
     */
    fun showToast(msg: String)
}
