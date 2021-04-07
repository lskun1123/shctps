package com.lsk.dao;

import com.lsk.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectAll();
}