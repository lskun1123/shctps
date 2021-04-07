package com.lsk.service;

import com.lsk.entity.User;

/**
 * @author LSKun
 */
public interface UserService {
    Boolean addUser(User user);

    User selectUser(String username);

    Boolean checkStatus(String username, String password);

    Boolean editUser(User user);
}
