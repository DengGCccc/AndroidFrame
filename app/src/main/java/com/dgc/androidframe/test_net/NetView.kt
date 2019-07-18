package com.dgc.androidframe.test_net

import com.dgc.framework.mvp.IMvpView

/**
 * Created by Deng on 2018/7/25.
 */
interface NetView : IMvpView {
    fun showData(data: String?)
}
