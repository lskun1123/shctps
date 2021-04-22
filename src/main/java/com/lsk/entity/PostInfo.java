package com.lsk.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LSKun
 */
public class PostInfo {
    private Integer postid;

    private Integer poster;

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

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent == null ? null : postcontent.trim();
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
        this.postimg = postimg == null ? null : postimg.trim();
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "postid=" + postid +
                ", poster=" + poster +
                ", postcontent='" + postcontent + '\'' +
                ", posttime=" + posttime +
                ", views=" + views +
                ", postimg='" + postimg + '\'' +
                '}';
    }
}