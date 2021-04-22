package com.lsk.controller;
/*
 * @Author LSKun1123
 * @Date 2021/4/20 20:27
 * @Return
 * @Desc
 */

import com.lsk.dto.Result;
import com.lsk.entity.ComplexOrder;
import com.lsk.entity.Goods;
import com.lsk.entity.Order;
import com.lsk.entity.User;
import com.lsk.service.GoodsService;
import com.lsk.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LSKun
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    /**
     * 用户发起交易请求，添加一条订单，将state置为0，表示买家发起交易，等待卖家确认交易
     * @param userId
     * @param gid
     * @param payAmount
     * @return
     * @date 2021-04-21 20:44:54
     */
    @RequestMapping("/addOrder")
    @ResponseBody
    public Boolean addOrder(String userId, String gid,String payAmount){
        Order order = new Order();
        order.setGid(Integer.parseInt(gid));
        order.setPayer(Integer.parseInt(userId));
        order.setPayamount(Float.valueOf(payAmount).floatValue());
        order.setState(0);
        System.out.println("order: " + order);
        Boolean isSuccess = orderService.addOrder(order);
        return isSuccess;
    }

    /**
     * 获取待确认的订单（买家用户在购买商品后，会向卖家发起确认，卖家在登陆后，通过调用这个接口就可以获取待确认的订单）
     * @param uid
     * @return
     * @date 2021-04-21 20:44:24
     */
    @RequestMapping("/getToBeConfirmed")
    @ResponseBody
    public Result<List<Order>> getToBeConfirmed(String uid){
        List<Order> list = orderService.getToBeConfirmed(Integer.parseInt(uid));
        return null;
    }

    /**
     * 确认订单
     * @param oid
     * @return
     * @date 2021-04-21 20:44:35
     */
    @RequestMapping("/confirmOrder")
    @ResponseBody
    public Boolean confirmOrder(String oid,String gid){
        Boolean isSuccess = orderService.confirmOrder(Integer.parseInt(oid),Integer.parseInt(gid));
        return isSuccess;
    }

    /**
     * 取消订单
     * @param gid
     * @param oid
     * @return
     * @date 2021-04-22 21:35:14
     */
    @RequestMapping("cancelOrder")
    @ResponseBody
    public Boolean cancelOrder(String gid,String oid){
        Boolean isSuccess = orderService.cancelOrder(Integer.parseInt(gid),Integer.parseInt(oid));
        return isSuccess;
    }

    /**
     * 该方法会查出与用户购买的所有订单（卖家已确认和卖家未确认的）
     * @param userId
     * @return
     * @date 2021-04-22 11:19:41
     */
    @RequestMapping("/selectOrderByPayer")
    @ResponseBody
    public Result<List<ComplexOrder>> selectOrderByPayer(String userId){
        List<ComplexOrder> list = orderService.selectOrderByPayer(Integer.parseInt(userId));
        Result<List<ComplexOrder>> result = new Result<>();
        result.setData(list);
        result.setCode(list != null ? Result.SUCCESS : Result.ERROR);
        return result;
    }
}
