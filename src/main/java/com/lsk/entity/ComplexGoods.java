package com.lsk.entity;
/*
 * @Author LSKun1123
 * @Date 2021/4/20 21:46
 * @Return
 * @Desc
 */

import java.sql.Timestamp;

public class ComplexGoods {
    private Integer gid;

    private String goodsname;

    private String goodsimg;

    private float goodsprice;

    private String goodsdesc;

    private int category;

    private User user;

    private int state;

    private String quality;

    private Timestamp issuedate;

    private Timestamp duedate;

    private float originalprice;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public Timestamp getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Timestamp issuedate) {
        this.issuedate = issuedate;
    }

    public Timestamp getDuedate() {
        return duedate;
    }

    public void setDuedate(Timestamp duedate) {
        this.duedate = duedate;
    }

    public float getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(float originalprice) {
        this.originalprice = originalprice;
    }

    @Override
    public String toString() {
        return "ComplexGoods{" +
                "gid=" + gid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsimg='" + goodsimg + '\'' +
                ", goodsprice=" + goodsprice +
                ", goodsdesc='" + goodsdesc + '\'' +
                ", category=" + category +
                ", user=" + user +
                ", state=" + state +
                ", quality='" + quality + '\'' +
                ", issuedate=" + issuedate +
                ", duedate=" + duedate +
                ", originalprice=" + originalprice +
                '}';
    }
}
