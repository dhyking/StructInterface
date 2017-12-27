package cn.exploration.structinterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.exploration.structinterface.presenter.BasePresenter;

/**
 * Created by JackDeng on 2017/12/27.
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    //1.表示层引用
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V) this);
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
