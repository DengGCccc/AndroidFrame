package com.dgc.framework.net

import java.io.Serializable

open class BaseBean<T> : Serializable {
    var code: Int = 0
    var msg: String? = null
    var body: T? = null
}
