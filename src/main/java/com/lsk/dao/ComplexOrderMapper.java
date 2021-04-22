package com.lsk.dao;

import com.lsk.entity.ComplexOrder;
import com.lsk.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/** @Author LSKun1123
 * @Date 2021/4/21 19:30
 * @Return
 * @Desc
 */
@Repository
public interface ComplexOrderMapper {
    List<Order> selectOrderByUid(int uid);

    List<ComplexOrder> selectOrderByPayer(int userid);
}
