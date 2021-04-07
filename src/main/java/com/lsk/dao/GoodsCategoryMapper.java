package com.lsk.dao;

import com.lsk.entity.GoodsCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Byte gcid);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Byte gcid);

    List<GoodsCategory> selectAll();

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);
}