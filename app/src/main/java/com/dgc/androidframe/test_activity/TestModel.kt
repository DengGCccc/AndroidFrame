package com.dgc.androidframe.test_activity

import android.os.Handler

import com.dgc.framework.net.Callback

/**
 * Created by Deng on 2018/7/25.
 */
object TestModel {
    /**
     * 获取网络接口数据
     *
     * @param param    请求参数
     * @param callback 数据回调接口
     */
    fun getNetData(param: String, callback: Callback<String>) {
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        Handler().postDelayed({
            when (param) {
                "normal" -> callback.onSuccess("根据参数" + param + "的请求网络数据成功")
                "failure" -> callback.onFailure("请求失败：参数有误")
            }
            callback.onComplete()
        }, 2000)
    }
}
