package com.lsk.controller;

import com.lsk.dto.Result;
import com.lsk.entity.Goods;
import com.lsk.entity.GoodsCategory;
import com.lsk.entity.User;
import com.lsk.service.GoodsService;
import com.lsk.util.Base;
import com.lsk.util.CosClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

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

    @Autowired
    User user;

    /**
     * @param session
     * @param goodsImg
     * @param goodsName
     * @param goodsPrice
     * @param goodsDesc
     * @param category
     * @param originalPrice
     * @param quality
     * @return
     */
    @RequestMapping("/releaseDo")
    public String upload(HttpSession session, @RequestParam("goodsImg") CommonsMultipartFile[] goodsImg,String goodsName,String goodsPrice,String goodsDesc, @RequestParam("category") String category,String originalPrice,String quality){
        User user = (User)session.getAttribute("CUR_USER");
        System.out.println(user.toString());
        Goods goods = new Goods();
        goods.setGoodsname(goodsName);
        goods.setGoodsprice(Float.valueOf(goodsPrice).floatValue());
        goods.setGoodsdesc(goodsDesc);
        goods.setCategory(Integer.valueOf(category).intValue());
        goods.setState(0);
        goods.setPid(user.getUid());
        goods.setOriginalprice(Float.valueOf(originalPrice).floatValue());
        goods.setQuality(quality);
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

    @RequestMapping("/upload")
    public String upload2(@RequestParam(value = "file",required = false) CommonsMultipartFile goodsImg){
        String goodsImgs = "";
        //for(CommonsMultipartFile multipartFile : goodsImg){
            if(!goodsImg.isEmpty()){
                String fileName = goodsImg.getOriginalFilename();
                File dir = new File("D://images");
                if(!dir.exists()){
                    dir.mkdirs();
                }
                String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
                goodsImgs += newFileName + ",";
                File file = new File(dir, newFileName);
                try {
                    //保存文件
                    goodsImg.transferTo(file);
                    CosClient.uploadFile(file,"goodsImg/"+newFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
               // break;
            }
        //}
        goodsImgs = goodsImgs.substring(0,goodsImgs.length() - 1);
        //goods.setGoodsimg(goodsImgs);
        System.out.println(goodsImgs);
        //Boolean isSuccess = goodsService.addGoods(goods);
        return "main";
    }

    /**
     * 2021-04-02 15:53:41
     * 获取商品分类
     * @return
     */
    @RequestMapping("/getCategory")
    @ResponseBody
    public Result<List<GoodsCategory>> getCategory(){
        List<GoodsCategory> categories = goodsService.getCategory();
        Result<List<GoodsCategory>> result = new Result<>();
        result.setData(categories);
        result.setCode(categories != null?Result.SUCCESS:Result.ERROR);
        return result;
    }

    /**
     * 2021-04-03 15:50:17
     * 获取商品列表信息（全查，分页）
     * @param pageNumber
     * @return
     */
    @RequestMapping("/getGoodsList")
    @ResponseBody
    public Result<List<Goods>> getGoodsList(String pageNumber){
        List<Goods> list = goodsService.getAbstractGoodsInfo(pageNumber);
        Result<List<Goods>> result = new Result<>();
        result.setData(list);
        result.setCode(list != null?Result.SUCCESS:Result.ERROR);
        return result;
    }

    /**
     * 2021-04-03 15:52:39
     * 跳转到商品详情界面
     * @return
     */
    @RequestMapping("/goodsInfo.html")
    public String goodsInfo(){
        return "goodsInfo";
    }

    /**
     *  2021-04-04 12:49:29
     * @param gid
     * @return
     */
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

    /**
     * 获取用户发布历史
     * 2021-04-11 15:46:26
     * @param session
     * @param pageNumber
     * @return
     */
    @RequestMapping("/getReleaseHistory")
    @ResponseBody
    public Result<List<Goods>> getReleaseHistory(HttpSession session,String pageNumber){

        user = (User) session.getAttribute("CUR_USER");
        List<Goods> list = new ArrayList<>();
        list = goodsService.getReleaseHistory(user.getUid(),pageNumber);
        Result<List<Goods>> result = new Result<>();
        result.setData(list);
        result.setCode(list != null?Result.SUCCESS:Result.ERROR);
        return result;
    }

    /**
     * 2021-04-11 15:51:44
     * 获取每日推荐
     * @return
     */
    @RequestMapping("/getDailyRecommendation")
    @ResponseBody
    public Result<HashMap<Integer, Goods>> getDailyRecommendation(){
        HashMap<Integer,Goods> hashMap = goodsService.getDailyRecommendation();
        Result<HashMap<Integer,Goods>> result = new Result<>();
        result.setData(hashMap);
        result.setCode(hashMap != null?Result.SUCCESS:Result.ERROR);
        return result;
    }

}
