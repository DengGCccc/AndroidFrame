package com.dgc.androidframe.test_activity

import com.dgc.framework.mvp.IMvpView

/**
 * Created by Deng on 2018/7/25.
 */
interface TestView : IMvpView {
    fun showData(data: String?)
}
