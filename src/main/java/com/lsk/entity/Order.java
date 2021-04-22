package com.lsk.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LSKun
 */
public class Order {
    private Long oid;

    private Integer gid;

    private Integer payer;

    private float payamount;

    private Timestamp dealtime;

    private int state;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getPayer() {
        return payer;
    }

    public void setPayer(Integer payer) {
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

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", gid=" + gid +
                ", payer=" + payer +
                ", payamount=" + payamount +
                ", dealtime=" + dealtime +
                ", state=" + state +
                '}';
    }
}