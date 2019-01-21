package com.dgc.androidframe.test_activity;


import com.dgc.androidframe.base.mvp.BasePresenter;
import com.dgc.androidframe.base.mvp.Callback;

/**
 * Created by Deng on 2018/7/25.
 */
public class TestPresenter extends BasePresenter<TestView> {
    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String params) {
        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }
        //显示正在加载进度条
        getView().showLoading();

        // 调用Model请求数据
        TestModel.getNetData(params, new Callback<String>() {
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据

                System.out.println(isViewAttached() + "===============");
                if (isViewAttached()) {
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                if (isViewAttached()) {
                    getView().showToast(msg);
                }
            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                if (isViewAttached()) {
                    getView().hideLoading();
                }
            }
        });
    }
}