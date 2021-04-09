package com.lsk.service.impl;

import com.lsk.dao.BannerMapper;
import com.lsk.dao.ManagerMapper;
import com.lsk.entity.Banner;
import com.lsk.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LSKun
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> getBanner() {
        return bannerMapper.getDayBanner();
    }
}
