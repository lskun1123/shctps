package com.lsk.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LSKun
 */
public class Review {
    private Integer rid;

    private Integer reviewer;

    private int viewobject;

    private Integer objectid;

    private String reviewcontent;

    private Timestamp reviewtime;

    private Integer postid;

    private String objectname;

    public String getObjectname() {
        return objectname;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public int getViewobject() {
        return viewobject;
    }

    public void setViewobject(int viewobject) {
        this.viewobject = viewobject;
    }

    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public String getReviewcontent() {
        return reviewcontent;
    }

    public void setReviewcontent(String reviewcontent) {
        this.reviewcontent = reviewcontent == null ? null : reviewcontent.trim();
    }

    public Timestamp getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Timestamp reviewtime) {
        this.reviewtime = reviewtime;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rid=" + rid +
                ", reviewer=" + reviewer +
                ", viewobject=" + viewobject +
                ", objectid=" + objectid +
                ", reviewcontent='" + reviewcontent + '\'' +
                ", reviewtime=" + reviewtime +
                ", postid=" + postid +
                ", objectname='" + objectname + '\'' +
                '}';
    }
}