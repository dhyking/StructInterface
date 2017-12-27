package cn.exploration.structinterface.model;

import java.util.List;

import cn.exploration.structinterface.bean.PicBean;

/**
 * 加载数据
 * Created by JackDeng on 2017/12/27.
 */

public interface IModel {
    void loadPic(LoadPicListener listener);
    //设计一个内部回调接口
    interface LoadPicListener{
        void onCompleted(List<PicBean> list);
    }
}
