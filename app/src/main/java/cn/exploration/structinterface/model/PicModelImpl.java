package cn.exploration.structinterface.model;

import java.util.ArrayList;
import java.util.List;

import cn.exploration.structinterface.R;
import cn.exploration.structinterface.bean.PicBean;

/**
 * Created by JackDeng on 2017/12/27.
 */

public class PicModelImpl implements IModel {
    @Override
    public void loadPic(LoadPicListener listener) {
        List<PicBean> list = getData();
        listener.onCompleted(list);
    }

    private List<PicBean> getData() {
        List<PicBean> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
//            int resId =getResources().getIdentifier("icon"+(i+1),"drawable",getPackageName());
            PicBean picBean = new PicBean("第"+i+"页", R.drawable.icon3);
            list.add(picBean);
        }
        return list;
    }
}
