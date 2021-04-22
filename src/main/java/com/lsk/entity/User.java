package com.lsk.entity;

import org.springframework.stereotype.Component;

/**
 * @author LSKun
 */
@Component
public class User {
    private Integer uid;

    private String openid;

    private String nickname;

    private String img;

    private String contact;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", img='" + img + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}