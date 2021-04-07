package com.lsk.entity;

import org.springframework.stereotype.Component;

/**
 * @author LSKun
 */
@Component
public class GoodsCategory {
    private Byte gcid;

    private String categoryname;

    private String categoryimg;

    public String getCategoryimg() {
        return categoryimg;
    }

    public void setCategoryimg(String categoryimg) {
        this.categoryimg = categoryimg;
    }

    public Byte getGcid() {
        return gcid;
    }

    public void setGcid(Byte gcid) {
        this.gcid = gcid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "gcid=" + gcid +
                ", categoryname='" + categoryname + '\'' +
                ", categoryimg='" + categoryimg + '\'' +
                '}';
    }
}