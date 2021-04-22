package com.lsk.service;

import com.lsk.entity.ComplexPostInfo;
import com.lsk.entity.ComplexReview;
import com.lsk.entity.PostInfo;
import com.lsk.entity.Review;

import java.util.List;

/**
 * @author LSKun
 */
public interface PostService {
    boolean addPostInfo(PostInfo postInfo);

    List<ComplexPostInfo> getPosts(String pageNumber);

    PostInfo getPostInfo(int postid);

    boolean insertView(Review review);

    List<ComplexReview> getReview(int postid);

    ComplexPostInfo getComplexPostInfo(int postid);
}
