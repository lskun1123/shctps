package com.lsk.service.impl;

import com.github.pagehelper.PageHelper;
import com.lsk.dao.ComplexPostInfoMapper;
import com.lsk.dao.ComplexReviewMapper;
import com.lsk.dao.PostInfoMapper;
import com.lsk.dao.ReviewMapper;
import com.lsk.entity.ComplexPostInfo;
import com.lsk.entity.ComplexReview;
import com.lsk.entity.PostInfo;
import com.lsk.entity.Review;
import com.lsk.service.PostService;
import com.lsk.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LSKun
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostInfoMapper postInfoMapper;

    @Autowired
    ComplexPostInfoMapper ComplexPostInfoMapper;

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    ComplexReviewMapper complexReviewMapper;

    @Override
    public boolean addPostInfo(PostInfo postInfo) {
        return postInfoMapper.insertSelective(postInfo) > 0;
    }

    @Override
    public List<ComplexPostInfo> getPosts(String pageNumber) {
        //PageHelper.startPage(Integer.parseInt(pageNumber), PageHelperUtil.POST_NUMBER);
        List<ComplexPostInfo> list = ComplexPostInfoMapper.getAllComplexPostInfo();
        return list;
    }

    @Override
    public PostInfo getPostInfo(int postid) {
        postInfoMapper.addViewer(postid);
        return postInfoMapper.selectByPrimaryKey(postid);
    }

    @Override
    public boolean insertView(Review review) {
        return reviewMapper.insertSelective(review) > 0;
    }

    @Override
    public List<ComplexReview> getReview(int postid) {
        //PageHelper.startPage(pageNumber,PageHelperUtil.REVIEW_NUMBER);
        List<ComplexReview> list = complexReviewMapper.selectByPostId(postid);
        return list;
    }

    @Override
    public ComplexPostInfo getComplexPostInfo(int postid) {
        //增加一条浏览量
        postInfoMapper.addViewer(postid);
        return ComplexPostInfoMapper.selectByPrimaryKey(postid);
    }
}
