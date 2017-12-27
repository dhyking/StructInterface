package cn.exploration.structinterface.view;

import java.util.List;

import cn.exploration.structinterface.bean.PicBean;

/**
 * 定义所有的ui逻辑
 * Created by JackDeng on 2017/12/27.
 */

public interface IView {
    void showLoading();
    //显示数据---使用回调的方式返回数据
    void showPic(List<PicBean> list);
}
