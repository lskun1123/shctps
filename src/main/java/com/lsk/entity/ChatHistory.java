package com.lsk.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LSKun
 */
public class ChatHistory {
    private Long cid;

    private Integer sayer;

    private Integer accepter;

    private String chatcontent;

    private Timestamp chattime;

    private int tag;

    private int isread;

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

    public Timestamp getChattime() {
        return chattime;
    }

    public void setChattime(Timestamp chattime) {
        this.chattime = chattime;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getIsread() {
        return isread;
    }

    public void setIsread(int isread) {
        this.isread = isread;
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
                ", isread=" + isread +
                '}';
    }
}