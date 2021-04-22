package com.lsk.service.impl;

import com.lsk.dao.FeedbackMapper;
import com.lsk.dao.UserMapper;
import com.lsk.entity.Feedback;
import com.lsk.entity.User;
import com.lsk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LSKun
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public Boolean addUser(User user) {
        return userMapper.insertSelective(user) > 0;
    }

    @Override
    public User selectUserByOpenID(String openID) {
        return userMapper.selectByOpenID(openID);
    }

    /**
     * 验证登陆人是否是我校人员
     * @param username
     * @param password
     * @return
     */
    @Override
    public Boolean checkStatus(String username, String password) {
        //这里本来应该调用学校的接口，但是没申请下来，就干脆统一返回为true
        return true;
    }

    @Override
    public Boolean editUser(User user) {
        return userMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public boolean addFeedback(Feedback feedback) {
        return feedbackMapper.insertSelective(feedback) > 0;
    }

    @Override
    public User selectUserByUserID(String pid) {
        return userMapper.selectByPrimaryKey(Integer.parseInt(pid));
    }
}
