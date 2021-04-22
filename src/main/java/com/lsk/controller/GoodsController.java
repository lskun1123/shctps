package com.lsk.controller;

import com.lsk.dto.Result;
import com.lsk.entity.Goods;
import com.lsk.entity.GoodsCategory;
import com.lsk.entity.GoodsCollection;
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
import java.sql.Timestamp;
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
     * 2021-04-11 20:00:35
     * @param userId
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
    public String upload(String userId, @RequestParam("goodsImg") String goodsImg,String goodsName,String goodsPrice,String goodsDesc, @RequestParam("category") String category,String originalPrice,String quality){
        System.out.println("图片： " + goodsImg);
        System.out.println("售价: " + goodsPrice);
        //User user = (User)session.getAttribute("CUR_USER");
        //System.out.println(user.toString());
        Goods goods = new Goods();
        goods.setGoodsname(goodsName);
        goods.setGoodsprice(Float.valueOf(goodsPrice).floatValue());
        if(goodsDesc != null){
            goods.setGoodsdesc(goodsDesc);
        }
        goods.setCategory(Integer.valueOf(category).intValue());
        goods.setState(0);
        goods.setPid(Integer.parseInt(userId));
        goods.setOriginalprice(Float.valueOf(originalPrice).floatValue());
        if(quality != null){
            goods.setQuality(quality);
        }
        goods.setIssuedate(new Timestamp(System.currentTimeMillis()));
        goods.setDuedate(new Timestamp(Base.randomAfterDate().getTime()));
        //String goodsImgs = "";
//        for(String multipartFile : goodsImg){
//            if(!multipartFile.isEmpty()){
//                goodsImgs += multipartFile + ",";
//            } else {
//                break;
//            }
//        }
        //goodsImgs = goodsImgs.substring(0,goodsImgs.length() - 1);
        goods.setGoodsimg(goodsImg);
        System.out.println(goods.toString());
        Boolean isSuccess = goodsService.addGoods(goods);

        return "main";
    }

    /**
     * 2021-04-02 15:59:49
     * @param goodsImg
     * @return
     */
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
        return getListResult(pageNumber);
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
     * @param uid
     * @return
     */
    @RequestMapping("/getReleaseHistory")
    @ResponseBody
    public Result<List<Goods>> getReleaseHistory(String uid){

        List<Goods> list = goodsService.getReleaseHistory(Integer.parseInt(uid));
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
    public Result<List<Goods>> getDailyRecommendation(){
        HashMap<Integer,Goods> hashMap = goodsService.getDailyRecommendation();
        Result<List<Goods>> result = new Result<>();
        List<Goods> list = new ArrayList<>();
        hashMap.forEach((key,value) -> {
            list.add(value);
        });
        result.setData(list);
        result.setCode(hashMap != null?Result.SUCCESS:Result.ERROR);
        return result;
    }

    /**
     * 物品搜索功能
     * @date 2021-04-11 20:18:12
     * @param key
     * @return
     */
    @RequestMapping("/searchGoods")
    @ResponseBody
    public Result<List<Goods>> searchGoods(String key,String pageNumber,String orderBy){
        HashMap<Integer,Goods> hashMap = null;
        if("0".equals(orderBy)){
            hashMap = goodsService.searchByKey(key,pageNumber);
        }else{
            hashMap = goodsService.searchByKeyOrderByPrice(key,pageNumber);
        }
        List<Goods> list = new ArrayList<>();
        hashMap.forEach((key2,value) -> {
            list.add(value);
        });
        Result<List<Goods>> result = new Result<>();
        result.setData(list);
        result.setCode(hashMap != null?Result.SUCCESS:Result.ERROR);
        return result;
    }

    /**
     * 用户收藏商品
     * 2021-04-12 10:01:38
     * @param session
     * @param gid 商品id
     * @return
     */
    @RequestMapping("/addGoodsCollection")
    @ResponseBody
    public boolean addGoodsCollection(HttpSession session,String gid){
        User user = (User) session.getAttribute("CUR_USER");
        GoodsCollection collection = new GoodsCollection();
        collection.setCollector(user.getUid());
        collection.setGid(Integer.parseInt(gid));
        boolean isSuccess = goodsService.addCollection(collection);
        return isSuccess;
    }

    /**
     *
     * @param session
     * @param pageNumber
     * @date 2021-04-16 11:06:27
     * @return
     */
    @RequestMapping("/getGoodsCollection")
    @ResponseBody
    public Result<List<Goods>> getGoodsCollection(HttpSession session,String pageNumber){
        User user = (User) session.getAttribute("CUR_USER");
        List<Goods> list = new ArrayList<>();
        list = goodsService.getGoodsCollection(user.getUid(),Integer.parseInt(pageNumber));
        Result<List<Goods>> listResult = new Result<>();
        listResult.setData(list);
        listResult.setCode(list != null?Result.SUCCESS:Result.ERROR);
        return listResult;
    }

    @RequestMapping("/chat.html")
    public String chat(){
        return "chat";
    }

    /**
     * 分类获取商品（分页）
     * @param category
     * @param pageNumber
     * @return
     * @date 2021-04-19 10:41:37
     */
    @RequestMapping("/getGoodsByCategory")
    @ResponseBody
    public Result<List<Goods>> getGoodsByCategory(String category,String pageNumber){
        if("0".equals(category)){
            return getListResult(pageNumber);
        }else{
            List<Goods> list = goodsService.getGoodsByCategory(Integer.parseInt(category),Integer.parseInt(pageNumber));
            Result<List<Goods>> result = new Result<>();
            result.setData(list);
            result.setCode(list != null?Result.SUCCESS:Result.ERROR);
            return result;
        }
    }

    /**
     * 获取商品摘要列表
     * @param pageNumber
     * @return
     * @date 2021-04-19 16:02:47
     */
    private Result<List<Goods>> getListResult(String pageNumber) {
        List<Goods> list = goodsService.getAbstractGoodsInfo(pageNumber);
        Result<List<Goods>> result = new Result<>();
        result.setData(list);
        result.setCode(list != null?Result.SUCCESS:Result.ERROR);
        return result;
    }
}
