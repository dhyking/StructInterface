package cn.exploration.structinterface.presenter;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;

import cn.exploration.structinterface.bean.PicBean;
import cn.exploration.structinterface.model.IModel;
import cn.exploration.structinterface.model.PicModelImpl;
import cn.exploration.structinterface.view.IView;

/**
 *  表示层
 * Created by JackDeng on 2017/12/27.
 */

public class PicPresenter<T extends IView> extends BasePresenter<T>{

    //2. model层的引用
    IModel iModel = new PicModelImpl();

    //3.构造方法
    public PicPresenter() {
//        this.iView = iView;
    }

    //4.执行操作（ui逻辑）
    public void fetch (){
        if (weakReference.get() != null) {
            weakReference.get().showLoading();
            if (iModel != null) {
                iModel.loadPic(new IModel.LoadPicListener() {
                    @Override
                    public void onCompleted(List<PicBean> list) {
                        if (weakReference.get() != null) {
                            weakReference.get().showPic(list);
                        }
                    }
                });
            }
        }
    }
}
