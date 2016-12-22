package com.ares.areslibrary.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ares.areslibrary.mvp.presenter.BasePresenter;

/**
 * MVP模式Fragment 基类
 * Created by Ares on 2016/12/22/022.
 */

public abstract class MVPFragment<V extends BaseView,P extends BasePresenter<V>> extends Fragment implements BaseView{

    protected P presenter;
    protected View rootView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter == null) {
            presenter= createPresenter();
        }
        presenter.attachView(getMvpView());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            recoverParams(bundle);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(),null);
        initParams(rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView(getRetainInstance());
    }

    /**
     * 获取布局
     * @return 布局资源Id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化参数
     */
    protected abstract void initParams(View rootView);

    /**
     * 恢复参数
     * @param bundle 保存的参数
     */
    protected abstract void recoverParams(Bundle bundle);

    /**
     * 创建Presenter对象
     * @return Presenter对象
     */
    protected abstract P createPresenter();

    /**
     * 获取相应的Fragment对象
     * @return
     */
    public V getMvpView(){
        return (V) this;
    }

    /**
     * 获取相应的Fragment的根布局
     * @return Fragment的根布局
     */
    public View getRootView(){
        return this.rootView;
    }
}
