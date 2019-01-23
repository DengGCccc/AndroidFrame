package com.dgc.androidframe;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dgc.androidframe.test_net.MyApi;
import com.dgc.framework.base.net.BaseObserver;
import com.dgc.androidframe.test_activity.TestActivity;
import com.dgc.framework.base.net.BaseApi;
import com.dgc.androidframe.test_net.TestBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deng on 2018/7/25.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void btnClick(View v) {
        startActivity(new Intent(this, TestActivity.class));
    }

    public void btnClick2(View v) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "AP170102105451");

        MyApi.getInstance().getUser(map, new BaseObserver<TestBean>(this) {
            @Override
            public void onSuccess(TestBean testBean) {

                ((TextView) findViewById(R.id.tv_result)).setText(testBean.getAge() + "=====" + testBean.getName());
            }
        });
    }
}
