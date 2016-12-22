package com.ares.areslibrary.mvp.presenter;

import com.ares.areslibrary.mvp.view.BaseView;

import java.lang.ref.WeakReference;

/**
 * MVP模式Presenter 基类
 * Created by Ares on 2016/12/22/022.
 */

public class BasePresenter <V extends BaseView>{

    private WeakReference<V> viewRef;


    public void attachView(V view){
        viewRef = new WeakReference<V>(view);
    }

    public void detachView(boolean retainInstance){
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * 获取 presenter 对应的view
     * @return 如果对应,返回对应实例,否则返回 null
     */
    public V getView() {
        return viewRef == null ? null :viewRef.get();
    }

    /**
     * 检查 presenter 是否存在对应View
     * @return 如果存在返回true, 否则返回false
     */
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

}
