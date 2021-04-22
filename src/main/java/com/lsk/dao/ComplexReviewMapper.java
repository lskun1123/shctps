package com.lsk.dao;

import com.lsk.entity.ComplexReview;
import org.springframework.stereotype.Repository;

import java.util.List;

/** @Author LSKun1123
 * @Date 2021/4/21 10:57
 * @Return
 * @Desc
 */
@Repository
public interface ComplexReviewMapper {

    List<ComplexReview> selectByPostId(int postid);
}
