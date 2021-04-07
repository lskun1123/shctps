package com.lsk.entity;

import org.springframework.stereotype.Component;

/**
 * @author LSKun
 */
@Component
public class Manager {
    private Integer mid;

    private String username;

    private String password;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}