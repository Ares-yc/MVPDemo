package com.ares.areslibrary.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ares.areslibrary.mvp.presenter.BasePresenter;

/**
 * MVP模式Fragment基类
 * Created by Ares on 2016/12/22/022.
 */

public abstract class MVPFragment<V extends BaseView,P extends BasePresenter<V>> extends Fragment implements BaseView{

    protected P presenter;

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
        View rootView = inflater.inflate(getLayoutId(),null);
        initParams();
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
    protected abstract void initParams();

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

    public V getMvpView(){
        return (V) this;
    }
}
