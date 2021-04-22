package com.lsk.entity;


import java.sql.Timestamp;

/** @author LSKun
 * @Date 2021/4/21 8:53 *
 * @Return
 * @Desc  复杂的帖子结果集
 */
public class ComplexPostInfo {
    private Integer postid;

    private User user;

    private String postcontent;

    private Timestamp posttime;

    private Integer views;

    private String postimg;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public Timestamp getPosttime() {
        return posttime;
    }

    public void setPosttime(Timestamp posttime) {
        this.posttime = posttime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getPostimg() {
        return postimg;
    }

    public void setPostimg(String postimg) {
        this.postimg = postimg;
    }

    @Override
    public String toString() {
        return "ComplexPostInfo{" +
                "postid=" + postid +
                ", user=" + user +
                ", postcontent='" + postcontent + '\'' +
                ", posttime=" + posttime +
                ", views=" + views +
                ", postimg='" + postimg + '\'' +
                '}';
    }
}
