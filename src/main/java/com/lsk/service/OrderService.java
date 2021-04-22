package com.lsk.service;
/*
 * @Author LSKun1123
 * @Date 2021/4/20 20:28
 * @Return
 * @Desc
 */

import com.lsk.entity.ComplexOrder;
import com.lsk.entity.Order;

import java.util.List;

/**
 * @author LSKun
 */
public interface OrderService {
    Boolean addOrder(Order order);

    List<Order> getToBeConfirmed(int uid);

    Boolean confirmOrder(int oid,int gid);

    List<ComplexOrder> selectOrderByPayer(int parseInt);

    Boolean cancelOrder(int gid, int oid);
}
