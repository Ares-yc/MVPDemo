package com.ares.areslibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment 基类
 * Created by Ares on 2016/12/22/022.
 * 在继承者内重写以下方法
 * public static FragmentDemo newInstance(Bundle bundle){
 *      FragmentDemo fragmentDemo = new FragmentDemo();
 *      fragmentDemo.setArguments(bundle);
 *      return fragmentDemo;
 * }
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(),null);
        initParams(rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            recoverParams(bundle);
        }
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
}
