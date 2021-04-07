package com.lsk.dao;

import com.lsk.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}