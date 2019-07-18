package com.dgc.framework.net

/**
 * Created by Deng on 2018/7/25.
 */
interface Callback<T> {
    /**
     * 数据请求成功
     *
     * @param data 请求到的数据
     */
    fun onSuccess(data: T?)

    /**
     * 使用网络API接口请求方式时，虽然已经请求成功但是由
     * 于`msg`的原因无法正常返回数据。
     */
    fun onFail(code: Int, msg: String?) {}

    /**
     * 当请求数据结束时，无论请求结果是成功，失败或是抛出异常都会执行此方法给用户做处理，通常做网络
     */
    fun onComplete() {}
}
