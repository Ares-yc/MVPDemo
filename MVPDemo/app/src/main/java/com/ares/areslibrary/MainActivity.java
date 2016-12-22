package com.ares.areslibrary;

import android.view.View;
import android.widget.Button;

import com.ares.areslibrary.mvp.view.BaseView;
import com.ares.areslibrary.mvp.view.MVPActivity;

public class MainActivity extends MVPActivity<MainActivity,MainPresenter> implements BaseView ,MainContract.View{

    Button click;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initParams() {
        click = (Button) findViewById(R.id.btn_click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.show();
            }
        });
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

}
