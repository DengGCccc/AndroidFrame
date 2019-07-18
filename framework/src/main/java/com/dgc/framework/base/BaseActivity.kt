package com.dgc.framework.base

import android.app.ProgressDialog
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.widget.Toast

import com.dgc.framework.mvp.IMvpView

import java.util.HashSet

/**
 * Created by Deng on 2018/7/25.
 */
abstract class BaseActivity : FragmentActivity(), IMvpView {

    private val presenterSet = HashSet<BasePresenter<*>>()

    private var mProgressDialog: ProgressDialog? = null

    override fun showLoading() {
        if (null == mProgressDialog) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.setCancelable(true)
        }

        if (!mProgressDialog!!.isShowing) {
            mProgressDialog!!.show()
        }
    }

    override fun hideLoading() {
        if (mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun addPresenters(presenter: BasePresenter<*>) {
        presenterSet.add(presenter)
    }

    override fun onDestroy() {
        super.onDestroy()

        for (presenter in presenterSet) {
            presenter.detachView()
        }
    }
}
