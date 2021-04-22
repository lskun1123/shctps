package com.lsk.dao;

import com.lsk.entity.ComplexPostInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/** @Author LSKun1123
 * @Date 2021/4/21 8:58
 * @Return
 * @Desc
 */
@Repository
public interface ComplexPostInfoMapper {
    List<ComplexPostInfo> getAllComplexPostInfo();

    ComplexPostInfo selectByPrimaryKey(int postid);
}
