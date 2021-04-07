package com.lsk.entity;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LSKun
 */
@Component
public class Goods {
    private Integer gid;

    private String goodsname;

    private String goodsimg;

    private float goodsprice;

    private String goodsdesc;

    private int category;

    private Integer pid;

    private int state;

    private Date issuedate;

    private Date duedate;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg == null ? null : goodsimg.trim();
    }

    public float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(float goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc == null ? null : goodsdesc.trim();
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsimg='" + goodsimg + '\'' +
                ", goodsprice=" + goodsprice +
                ", goodsdesc='" + goodsdesc + '\'' +
                ", category=" + category +
                ", pid=" + pid +
                ", state=" + state +
                ", issuedate=" + issuedate +
                ", duedate=" + duedate +
                '}';
    }
}