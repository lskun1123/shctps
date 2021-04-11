package com.lsk.service.impl;

import com.github.pagehelper.PageHelper;
import com.lsk.dao.GoodsCategoryMapper;
import com.lsk.dao.GoodsMapper;

import com.lsk.entity.Goods;
import com.lsk.entity.GoodsCategory;
import com.lsk.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LSKun
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> getCategory() {
        return goodsCategoryMapper.selectAll();
    }

    @Override
    public Boolean addGoods(Goods goods) {
        return goodsMapper.insertSelective(goods) > 0;
    }

    @Override
    public List<Goods> getAbstractGoodsInfo(String pageNumber) {
        //开始分页
        PageHelper.startPage(Integer.parseInt(pageNumber),4);
        List<Goods> list = goodsMapper.selectAll();
        return list;
    }

    @Override
    public Goods getGoodsInfo(String gid) {
        return goodsMapper.selectByPrimaryKey(Integer.parseInt(gid));
    }

    @Override
    public List<Goods> getReleaseHistory(Integer uid,String pageNumber) {
        //开始分页
        PageHelper.startPage(Integer.parseInt(pageNumber),4);
        return goodsMapper.selectByPid(uid);
    }

    @Override
    public HashMap<Integer,Goods> getDailyRecommendation() {
        List<Goods> orderByOldRelease = goodsMapper.selectorderByOldRelease();
        List<Goods> orderByNewRelease = goodsMapper.selectOrderByNewRelease();
        HashMap<Integer,Goods> map = new HashMap<>();
        for(Goods goods:orderByOldRelease){
            map.put(goods.getGid(),goods);
        }
        for(Goods goods:orderByNewRelease){
            map.put(goods.getGid(),goods);
        }
        return map;
    }
}
