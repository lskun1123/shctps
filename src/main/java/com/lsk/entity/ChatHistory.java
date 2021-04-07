package com.lsk.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LSKun
 */
@Component
public class ChatHistory {

    private Long cid;

    private Integer sayer;

    private Integer accepter;

    private String chatcontent;

    private Date chattime;

    private Byte tag;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getSayer() {
        return sayer;
    }

    public void setSayer(Integer sayer) {
        this.sayer = sayer;
    }

    public Integer getAccepter() {
        return accepter;
    }

    public void setAccepter(Integer accepter) {
        this.accepter = accepter;
    }

    public String getChatcontent() {
        return chatcontent;
    }

    public void setChatcontent(String chatcontent) {
        this.chatcontent = chatcontent == null ? null : chatcontent.trim();
    }

    public Date getChattime() {
        return chattime;
    }

    public void setChattime(Date chattime) {
        this.chattime = chattime;
    }

    public Byte getTag() {
        return tag;
    }

    public void setTag(Byte tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ChatHistory{" +
                "cid=" + cid +
                ", sayer=" + sayer +
                ", accepter=" + accepter +
                ", chatcontent='" + chatcontent + '\'' +
                ", chattime=" + chattime +
                ", tag=" + tag +
                '}';
    }
}