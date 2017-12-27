package cn.exploration.structinterface.bean;

import java.io.Serializable;

/**
 * Created by JackDeng on 2017/12/27.
 */

public class PicBean implements Serializable{
    private String title;
    private int imgId;

    public PicBean(String title, int imgId) {
        this.title = title;
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
