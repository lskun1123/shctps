package com.lsk.service;


import com.lsk.entity.Goods;
import com.lsk.entity.GoodsCategory;

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
}
