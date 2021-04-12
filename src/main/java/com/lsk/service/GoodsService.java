package com.lsk.service;


import com.lsk.entity.Goods;
import com.lsk.entity.GoodsCategory;
import com.lsk.entity.GoodsCollection;

import java.util.HashMap;
import java.util.List;

/**
 * @author LSKun
 */
public interface GoodsService {
    /**
     * 获取商品类别
     * @return
     */
    List<GoodsCategory> getCategory();

    Boolean addGoods(Goods goods);

    List<Goods> getAbstractGoodsInfo(String pageNumber);

    Goods getGoodsInfo(String gid);

    List<Goods> getReleaseHistory(Integer uid, String pageNumber);

    HashMap<Integer,Goods> getDailyRecommendation();

    HashMap<Integer, Goods> searchByKey(String key,String pageNumber);

    boolean addCollection(GoodsCollection collection);

    List<Goods> getGoodsCollection(Integer uid,Integer pageNumber);
}
