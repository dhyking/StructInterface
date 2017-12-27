package cn.exploration.structinterface.presenter;

import java.lang.ref.WeakReference;

import cn.exploration.structinterface.model.IModel;
import cn.exploration.structinterface.model.PicModelImpl;
import cn.exploration.structinterface.view.IView;

/**
 * 基类
 * Created by JackDeng on 2017/12/27.
 */

public class BasePresenter<T> {
    //1. view层的引用
    IView iView;
    protected WeakReference<T> weakReference;
    //进行绑定
    public void attachView(T iView){
        weakReference = new WeakReference<T>(iView);
    }

    //进行解绑
    public void detach(){
        weakReference.clear();
    }
}
