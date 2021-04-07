package com.lsk.dao;

import com.lsk.entity.PostInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author LSKun
 */
@Repository
public interface PostInfoMapper {
    int deleteByPrimaryKey(Integer postid);

    int insert(PostInfo record);

    int insertSelective(PostInfo record);

    PostInfo selectByPrimaryKey(Integer postid);

    int updateByPrimaryKeySelective(PostInfo record);

    int updateByPrimaryKey(PostInfo record);
}