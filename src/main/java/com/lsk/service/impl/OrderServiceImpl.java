package com.lsk.service.impl;
/*
 * @Author LSKun1123
 * @Date 2021/4/20 20:28
 * @Return
 * @Desc
 */

import com.lsk.dao.ComplexOrderMapper;
import com.lsk.dao.GoodsMapper;
import com.lsk.dao.OrderMapper;
import com.lsk.entity.ComplexOrder;
import com.lsk.entity.Order;
import com.lsk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author LSKun
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ComplexOrderMapper complexOrderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Boolean addOrder(Order order) {
        return orderMapper.insertSelective(order) > 0;
    }

    @Override
    public List<Order> getToBeConfirmed(int uid) {
        return complexOrderMapper.selectOrderByUid(uid);
    }

    @Override
    public Boolean confirmOrder(int oid,int gid) {
        //确认订单有三个操作：1更改订单表的交易时间，2更改订单表的state
        //如果返回结果不为2，手动回滚
        int res = orderMapper.confirmOrder(oid,new Timestamp(System.currentTimeMillis()))  + goodsMapper.updateState(gid);
        if(res != 2){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    @Override
    public List<ComplexOrder> selectOrderByPayer(int userid) {
        return complexOrderMapper.selectOrderByPayer(userid);
    }

    @Override
    public Boolean cancelOrder(int gid, int oid) {
        int res = goodsMapper.updateStateTo1(gid) + orderMapper.updateStateTo2(oid);
        if(res != 2){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }
}
