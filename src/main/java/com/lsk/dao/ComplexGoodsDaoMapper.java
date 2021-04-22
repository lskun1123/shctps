package com.lsk.dao;
/*
 * @Author LSKun1123
 * @Date 2021/4/20 21:47
 * @Return
 * @Desc
 */

import com.lsk.entity.ComplexGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface ComplexGoodsDaoMapper {
    List<ComplexGoods> selectAllComplexGoods();
}
