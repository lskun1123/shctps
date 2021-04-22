package com.lsk.entity;

import java.sql.Timestamp;

/** @Author LSKun1123
 * @Date 2021/4/21 10:54
 * @Return
 * @Desc
 */
public class ComplexReview {
    private Integer rid;

    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        this.reviewcontent = reviewcontent;
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
        return "ComplexReview{" +
                "rid=" + rid +
                ", user=" + user +
                ", viewobject=" + viewobject +
                ", objectid=" + objectid +
                ", reviewcontent='" + reviewcontent + '\'' +
                ", reviewtime=" + reviewtime +
                ", postid=" + postid +
                ", objectname='" + objectname + '\'' +
                '}';
    }
}
