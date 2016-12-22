package com.ares.areslibrary.sample;

import android.widget.Button;

import com.ares.areslibrary.R;
import com.ares.areslibrary.mvp.presenter.BasePresenter;

/**
 * MainActivty Presenter
 * Created by Ares on 2016/12/22/022.
 */

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter{

    @Override
    public void show() {
        MainActivity mainActivity = getView();
        Button click = (Button) mainActivity.findViewById(R.id.btn_click);
        if (click != null) {
            click.setText("Done");
        }
    }
}
