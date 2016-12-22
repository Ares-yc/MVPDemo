package com.ares.areslibrary.sample;

import android.widget.Button;

import com.ares.areslibrary.R;
import com.ares.areslibrary.mvp.presenter.BasePresenter;

/**
 * MainActivty Presenter
 * Created by Ares on 2016/12/22/022.
 */

public class MainFragPresenter extends BasePresenter<MainFragment> implements MainContract.Presenter{

    @Override
    public void show() {
        MainFragment mainFragment = getView();
        Button click = (Button) mainFragment.getRootView().findViewById(R.id.btn_click);
        if (click != null) {
            click.setText("Done.");
        }
    }
}
