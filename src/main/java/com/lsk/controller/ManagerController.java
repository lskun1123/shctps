package com.lsk.controller;

import com.lsk.dto.Result;
import com.lsk.entity.Banner;
import com.lsk.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LSKun
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @RequestMapping("/getBanner")
    @ResponseBody
    public Result<List<Banner>> getBanner(){
        List<Banner> list = new ArrayList<>();
        list = managerService.getBanner();
        Result<List<Banner>> result = new Result<>();
        result.setData(list);
        result.setCode(list != null?Result.SUCCESS:Result.ERROR);
        return result;
    }
}
