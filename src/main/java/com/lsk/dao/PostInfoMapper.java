package com.lsk.dao;

import com.lsk.entity.PostInfo;

import java.util.List;

public interface PostInfoMapper {
    int deleteByPrimaryKey(Integer postid);

    int insert(PostInfo record);

    int insertSelective(PostInfo record);

    PostInfo selectByPrimaryKey(Integer postid);

    int updateByPrimaryKeySelective(PostInfo record);

    int updateByPrimaryKey(PostInfo record);

    List<PostInfo> selectAll();

    int addViewer(Integer postid);
}