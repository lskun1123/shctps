package com.lsk.dao;

import com.lsk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    User selectBySnumber(@Param("snumber") String snumber);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}