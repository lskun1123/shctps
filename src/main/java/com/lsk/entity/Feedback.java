package com.lsk.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Feedback {
    private Integer fid;

    private Integer uid;

    private Timestamp feedbacktime;

    private String msg;

    private String feedimg;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Timestamp getFeedbacktime() {
        return feedbacktime;
    }

    public void setFeedbacktime(Timestamp feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getFeedimg() {
        return feedimg;
    }

    public void setFeedimg(String feedimg) {
        this.feedimg = feedimg == null ? null : feedimg.trim();
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "fid=" + fid +
                ", uid=" + uid +
                ", feedbacktime=" + feedbacktime +
                ", msg='" + msg + '\'' +
                ", feedimg='" + feedimg + '\'' +
                '}';
    }
}