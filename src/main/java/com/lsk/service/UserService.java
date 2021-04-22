package com.lsk.service;

import com.lsk.entity.Feedback;
import com.lsk.entity.User;

/**
 * @author LSKun
 */
public interface UserService {
    Boolean addUser(User user);

    User selectUserByOpenID(String openID);

    Boolean checkStatus(String username, String password);

    Boolean editUser(User user);

    boolean addFeedback(Feedback feedback);

    User selectUserByUserID(String pid);
}
