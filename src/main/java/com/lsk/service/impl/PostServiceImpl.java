package com.lsk.service.impl;

import com.lsk.dao.PostInfoMapper;
import com.lsk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LSKun
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostInfoMapper postInfoMapper;
}
