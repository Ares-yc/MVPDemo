package com.ares.areslibrary.sample;

import com.ares.areslibrary.R;
import com.ares.areslibrary.mvp.view.BaseView;
import com.ares.areslibrary.mvp.view.MVPActivity;

public class MainActivity extends MVPActivity<MainActivity,MainPresenter> implements BaseView ,MainContract.View{


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initParams() {
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance(null);
        }
        addFragmentToActivity(getSupportFragmentManager(),R.id.fl_content,mainFragment);
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

}
