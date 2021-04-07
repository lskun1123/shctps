package com.lsk.entity;

import org.springframework.stereotype.Component;

/**
 * @author LSKun
 */
@Component
public class GoodsCollection {
    private Integer cid;

    private Integer collector;

    private Integer gid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCollector() {
        return collector;
    }

    public void setCollector(Integer collector) {
        this.collector = collector;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "GoodsCollection{" +
                "cid=" + cid +
                ", collector=" + collector +
                ", gid=" + gid +
                '}';
    }
}