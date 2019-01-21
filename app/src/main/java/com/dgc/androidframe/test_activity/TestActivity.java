package com.dgc.androidframe.test_activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dgc.androidframe.R;
import com.dgc.androidframe.base.BaseActivity;


public class TestActivity extends BaseActivity implements TestView {
    TextView text;
    TestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        text = (TextView) findViewById(R.id.text);
        //初始化Presenter
        presenter = new TestPresenter();
        presenter.attachView(this);
        addPresenters(presenter);
    }

    public void btnClick(View v) {
        presenter.getData("normal");
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

}