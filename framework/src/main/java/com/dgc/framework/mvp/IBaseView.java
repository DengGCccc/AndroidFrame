package com.dgc.framework.mvp;

import android.content.Context;

/**
 * Created by Deng on 2018/7/25.
 */
public interface IBaseView {
    /**
     * 显示正在加载进度条
     */
    void showLoading();

    /**
     * 关闭正在加载进度条
     */
    void hideLoading();

    /**
     * Toast提示
     *
     * @param msg
     */
    void showToast(String msg);

    /**
     * 获取上下文
     *
     * @return 上下文
     */
    Context getContext();
}
