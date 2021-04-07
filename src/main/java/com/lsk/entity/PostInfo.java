package com.lsk.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LSKun
 */
@Component
public class PostInfo {
    private Integer postid;

    private Integer poster;

    private String postcontent;

    private Date posttime;

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

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "postid=" + postid +
                ", poster=" + poster +
                ", postcontent='" + postcontent + '\'' +
                ", posttime=" + posttime +
                '}';
    }
}