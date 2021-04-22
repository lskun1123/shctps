package com.lsk.dao;

import com.lsk.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface OrderMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int confirmOrder(@Param("oid")int oid, @Param("dealtime") Timestamp dealtime);

    int updateStateTo2(int oid);
}