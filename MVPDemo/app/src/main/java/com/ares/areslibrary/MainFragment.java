package com.ares.areslibrary;

import android.os.Bundle;

import com.ares.areslibrary.mvp.view.BaseView;
import com.ares.areslibrary.mvp.view.MVPFragment;

/**
 * MainFragment
 * Created by Ares on 2016/12/22/022.
 */

public class MainFragment extends MVPFragment<MainFragment,MainFragPresenter> implements BaseView ,MainContract.View{

    public static MainFragment newInstance(Bundle bundle){
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initParams() {

    }

    @Override
    protected void recoverParams(Bundle bundle) {

    }

    @Override
    protected MainFragPresenter createPresenter() {
        return new MainFragPresenter();
    }

}
