package com.lsk.dao;

import com.lsk.entity.Goods;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectAll();

    List<Goods> selectByPid(@Param("pid") Integer uid);

    @MapKey("gid")
    List<Goods> selectOrderByNewRelease();

    List<Goods> selectorderByOldRelease();

    List<Goods> selectByGoodsName(String key);

    List<Goods> selectByGoodsDesc(String key);

    List<Goods> getGoodsCollection(Integer uid);

    List<Goods> selectByGoodsNameOrderByPrice(String key);

    List<Goods> selectByGoodsDescOrderByPrice(String key);

    List<Goods> getGoodsByCategory(Integer category);

    int updateState(int gid);

    int updateStateTo1(int gid);
}