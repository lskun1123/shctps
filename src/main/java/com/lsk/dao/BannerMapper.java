package com.lsk.dao;

import com.lsk.entity.Banner;
import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}