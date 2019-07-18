package com.dgc.androidframe.test_net

import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.dgc.androidframe.R
import com.dgc.framework.base.BaseActivity

class NetActivity : BaseActivity(), NetView {
    private lateinit var text: TextView
    private lateinit var presenter: NetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        text = findViewById(R.id.text)

        presenter = NetPresenter()
        presenter.attachView(this)
        addPresenters(presenter)
    }

    fun btnClick(v: View?) {
        presenter.getUserInfo()
    }

    override fun showData(data: String?) {
        text.text = data
    }
}