package com.lsk.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LSKun
 */
@Component
public class Review {
    private Integer rid;

    private Integer reviewer;

    private Byte viewobject;

    private Integer objectid;

    private String reviewcontent;

    private Date reviewtime;

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

    public Byte getViewobject() {
        return viewobject;
    }

    public void setViewobject(Byte viewobject) {
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

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
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
                '}';
    }
}