package com.lsk.entity;

import java.sql.Timestamp;

/** @Author LSKun1123
 * @Date 2021/4/21 19:27
 * @Return
 * @Desc
 */
public class ComplexOrder {
    private Long oid;

    private Goods goods;

    private User payer;

    private float payamount;

    private Timestamp dealtime;

    private int state;

    private int uid;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public float getPayamount() {
        return payamount;
    }

    public void setPayamount(float payamount) {
        this.payamount = payamount;
    }

    public Timestamp getDealtime() {
        return dealtime;
    }

    public void setDealtime(Timestamp dealtime) {
        this.dealtime = dealtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "ComplexOrder{" +
                "oid=" + oid +
                ", goods=" + goods +
                ", payer=" + payer +
                ", payamount=" + payamount +
                ", dealtime=" + dealtime +
                ", state=" + state +
                ", uid=" + uid +
                '}';
    }
}
