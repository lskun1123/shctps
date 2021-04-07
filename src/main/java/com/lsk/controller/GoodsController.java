package com.lsk.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.lsk.dto.Result;
import com.lsk.entity.Goods;
import com.lsk.entity.GoodsCategory;
import com.lsk.entity.User;
import com.lsk.service.GoodsService;
import com.lsk.util.Base;
import com.lsk.util.CosClient;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author LSKun
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    Goods goods;

    @RequestMapping("/releaseDo")
    public String upload(HttpSession session, @RequestParam("goodsImg") CommonsMultipartFile[] goodsImg,String goodsName,String goodsPrice,String goodsDesc, @RequestParam("category") String category){
        User user = (User)session.getAttribute("CUR_USER");
        System.out.println(user.toString());
        Goods goods = new Goods();
        goods.setGoodsname(goodsName);
        goods.setGoodsprice(Float.valueOf(goodsPrice).floatValue());
        goods.setGoodsdesc(goodsDesc);
        goods.setCategory(Integer.valueOf(category).intValue());
        goods.setState(0);
        goods.setPid(user.getUid());
        goods.setIssuedate(new Date());
        goods.setDuedate(Base.randomAfterDate());
        String goodsImgs = "";
        for(CommonsMultipartFile multipartFile : goodsImg){
            if(!multipartFile.isEmpty()){
                String fileName = multipartFile.getOriginalFilename();
                File dir = new File("D://images");
                if(!dir.exists()){
                    dir.mkdirs();
                }
                String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
                goodsImgs += newFileName + ",";
                File file = new File(dir, newFileName);
                try {
                    //保存文件
                    multipartFile.transferTo(file);
                    CosClient.uploadFile(file,"goodsImg/"+newFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
        goodsImgs = goodsImgs.substring(0,goodsImgs.length() - 1);
        goods.setGoodsimg(goodsImgs);
        System.out.println(goods.toString());
        Boolean isSuccess = goodsService.addGoods(goods);

        return "main";
    }

    @RequestMapping("/getCategory")
    @ResponseBody
    public Result<List<GoodsCategory>> getCategory(){
        List<GoodsCategory> categories = goodsService.getCategory();
        Result<List<GoodsCategory>> result = new Result<>();
        result.setData(categories);
        result.setCode(categories != null?Result.SUCCESS:Result.ERROR);
        return result;
    }

    @RequestMapping("/getGoodsList")
    @ResponseBody
    public Result<List<Goods>> getGoodsList(String pageNumber){
        List<Goods> list = goodsService.getAbstractGoodsInfo(pageNumber);
        Result<List<Goods>> result = new Result<>();
        result.setData(list);
        result.setCode(list != null?Result.SUCCESS:Result.ERROR);
        return result;
    }



    @RequestMapping("/goodsInfo.html")
    public String goodsInfo(){
        return "goodsInfo";
    }

    @RequestMapping("/getGoodsInfo")
    @ResponseBody
    public Result<Goods> getGoodsInfo(@RequestParam("gid") String gid){
        System.out.println("gid: " + gid);
        goods = goodsService.getGoodsInfo(gid);
        Result<Goods> result = new Result<>();
        result.setData(goods);
        result.setCode(goods!= null?Result.SUCCESS:Result.ERROR);
        System.out.println(result);
        return result;
    }

}
