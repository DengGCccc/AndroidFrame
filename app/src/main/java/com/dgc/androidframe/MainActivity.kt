package com.dgc.androidframe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.dgc.androidframe.test_net.TestApi
import com.dgc.framework.net.BaseObserver
import com.dgc.androidframe.test_activity.TestActivity
import com.dgc.androidframe.test_net.TestBean

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
        startActivity(Intent(this, TestActivity::class.java))
    }

    fun btnClick2(v: View) {
        val map = HashMap<String, Any>()
        map.put("userId", "AP170102105451")

//        TestApi.instance.getUser(map, object : BaseObserver<TestBean>(this) {
//            override fun onSuccess(testBean: TestBean) {
//
//                (findViewById<View>(R.id.tv_result) as TextView).text =
//                    testBean.age.toString() + "=====" + testBean.name
//            }
//        })
    }
}
