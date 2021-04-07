package com.lsk.dao;

import com.lsk.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface ReviewMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Review record);

    int insertSelective(Review record);

    Review selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
}