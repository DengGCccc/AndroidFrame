package com.dgc.androidframe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.dgc.androidframe.test_net.TestApi
import com.dgc.framework.net.NormalObserver
import com.dgc.androidframe.test_net.NetActivity
import com.dgc.androidframe.test_net.UserBean

import java.util.HashMap

/**
 * Created by Deng on 2018/7/25.
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun btnClick(v: View) {
        startActivity(Intent(this, NetActivity::class.java))
    }
}
