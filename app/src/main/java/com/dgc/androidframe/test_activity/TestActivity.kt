package com.dgc.androidframe.test_activity

import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.dgc.androidframe.R
import com.dgc.framework.base.BaseActivity

class TestActivity : BaseActivity(), TestView {
    private lateinit var text: TextView
    private lateinit var presenter: TestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        text = findViewById(R.id.text)

        presenter = TestPresenter()
        presenter.attachView(this)
        addPresenters(presenter)
    }

    fun btnClick(v: View?) {
        presenter.getData("normal")
    }

    override fun showData(data: String?) {
        text.text = data
    }
}