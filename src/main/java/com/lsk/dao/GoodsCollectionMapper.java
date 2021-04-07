package com.lsk.dao;

import com.lsk.entity.GoodsCollection;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface GoodsCollectionMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(GoodsCollection record);

    int insertSelective(GoodsCollection record);

    GoodsCollection selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(GoodsCollection record);

    int updateByPrimaryKey(GoodsCollection record);
}