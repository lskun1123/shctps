package com.lsk.service.impl;

import com.lsk.dao.ManagerMapper;
import com.lsk.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LSKun
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;
}
