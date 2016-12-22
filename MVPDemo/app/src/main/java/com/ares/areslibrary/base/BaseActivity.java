package com.ares.areslibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity 基类
 * Created by Ares on 2016/12/22/022.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        BaseApplication.addActivity(this);
        initParams();
    }

    /**
     * 获取布局
     * @return 布局资源Id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化参数
     */
    protected abstract void initParams();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.removeActivity(this);
    }
}
