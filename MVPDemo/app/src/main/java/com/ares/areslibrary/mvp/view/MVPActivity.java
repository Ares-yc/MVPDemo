package com.ares.areslibrary.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ares.areslibrary.base.BaseApplication;
import com.ares.areslibrary.mvp.presenter.BasePresenter;

/**
 * Created by Ares on 2016/12/22/022.
 */

public abstract class MVPActivity<V extends BaseView,P extends BasePresenter<V>> extends AppCompatActivity implements BaseView{

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        BaseApplication.addActivity(this);
        presenter = createPresenter();
        presenter.attachView(getMvpView());
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

    /**
     * 创建Presenter对象
     * @return Presenter对象
     */
    protected abstract P createPresenter();

    public V getMvpView(){
        return (V) this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.removeActivity(this);
        presenter.detachView(false);
    }

}
