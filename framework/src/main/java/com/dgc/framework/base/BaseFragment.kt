package com.dgc.framework.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dgc.framework.mvp.IMvpView

/**
 * Created by Deng on 2018/7/25.
 */
abstract class BaseFragment : Fragment(), IMvpView {
    abstract val contentViewId: Int

    protected open var mContext: Context? = null
    protected open lateinit var mRootView: View

    protected abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(contentViewId, container, false)
        this.mContext = activity
        initView(savedInstanceState)
        return mRootView
    }

    override fun showLoading() {
        checkActivityAttached()
        (mContext as BaseActivity).showLoading()
    }

    override fun hideLoading() {
        checkActivityAttached()
        (mContext as BaseActivity).hideLoading()
    }

    override fun showToast(msg: String) {
        checkActivityAttached()
        (mContext as BaseActivity).showToast(msg)
    }

    protected fun checkActivityAttached() {
        if (null == activity) {
            throw ActivityNotAttachedException()
        }
    }

    class ActivityNotAttachedException : RuntimeException("Fragment has disconnected from Activity ! - -.")
}
