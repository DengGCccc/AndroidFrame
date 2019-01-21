package com.dgc.androidframe.test_activity;


import com.dgc.androidframe.base.mvp.IBaseView;

/**
 * Created by Deng on 2018/7/25.
 */
public interface TestView extends IBaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);

}
