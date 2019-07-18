package com.dgc.androidframe

import android.app.Application
import com.dgc.androidframe.utils.RuntimeContext

/**
 * Created by Deng on 2018/7/26.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        RuntimeContext.sApplicationContext = this
    }
}
