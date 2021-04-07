package com.lsk.entity;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LSKun
 */
@Component
public class Order {
    private Long oid;

    private Integer gid;

    private Integer payer;

    private float payamount;

    private Date dealtime;

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

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", gid=" + gid +
                ", payer=" + payer +
                ", payamount=" + payamount +
                ", dealtime=" + dealtime +
                '}';
    }
}