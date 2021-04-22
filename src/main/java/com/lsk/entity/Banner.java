package com.lsk.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LSKun
 */
public class Banner {
    private Integer bid;

    private String img;

    private Timestamp issuedate;

    private Integer mid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Timestamp getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Timestamp issuedate) {
        this.issuedate = issuedate;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "bid=" + bid +
                ", img='" + img + '\'' +
                ", issuedate=" + issuedate +
                ", mid=" + mid +
                '}';
    }
}