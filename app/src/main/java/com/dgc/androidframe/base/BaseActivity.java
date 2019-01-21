package com.dgc.androidframe.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.dgc.androidframe.base.mvp.BasePresenter;
import com.dgc.androidframe.base.mvp.IBaseView;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deng on 2018/7/25.
 */
public abstract class BaseActivity extends FragmentActivity implements IBaseView {

    private Set<BasePresenter> presenterSet = new HashSet<>();

    private ProgressDialog mProgressDialog;

    @Override
    public void showLoading() {
        if (null == mProgressDialog) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(true);
        }

        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    protected void addPresenters(BasePresenter presenter) {
        if (null != presenterSet) {
            presenterSet.add(presenter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        for (BasePresenter presenter : presenterSet) {
            if (null != presenter) {
                presenter.detachView();
            }
        }
    }
}
