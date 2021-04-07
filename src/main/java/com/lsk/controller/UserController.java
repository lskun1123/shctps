package com.lsk.controller;

import com.lsk.dto.Result;
import com.lsk.entity.User;
import com.lsk.service.UserService;
import com.lsk.util.Configure;
import com.lsk.util.CosClient;
import com.lsk.util.HttpUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author LSKun
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    User user;

    @RequestMapping("/reg.html")
    public String reg(){
        return "reg";
    }

    @RequestMapping(value = "/regDo",method = {RequestMethod.POST})
    public String regDo(String snumber){
        System.out.println("snumber：" + snumber);
        User user = new User();
        //user.setSnumber(snumber);
        user.setImg("default.jpg");
        Boolean isSuccess = userService.addUser(user);
        return "redirect:"+(isSuccess?"/user/login.html":"/user/reg.html");
    }

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @PostMapping("/miniLogin")
    @ResponseBody
    public Map mini_Login(HttpServletRequest request,@RequestParam("code") String openId) {
        // String c=request.getParameter("code");//也可以通过此语句获取code值
        System.out.println(openId);

        Map res = new HashMap();
        String result = "";
        // 请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
        try {
          result =
              HttpUtil.doGet(
                  "https://api.weixin.qq.com/sns/jscode2session?appid="
                      + Configure.mini_appID
                      + "&secret="
                      + Configure.mini_secret
                      + "&js_code="
                      + openId
                      + "&grant_type=authorization_code",
                  null);
        } catch (Exception e) {
          e.printStackTrace();
        }
        // System.out.println(result);
        // 解析从微信服务器上获取到的json字符串
        JSONObject jsonObj = JSONObject.fromObject(result);
        // 此处也可以得到session_key的值
        System.out.println("用户的openid为：" + jsonObj.get("openid"));
        res.put("session_key", jsonObj.get("session_key").toString());
        // 这里Miniuser类是自己的业务类，你可以根据自己需要自行定义
        // 去数据库判断用户是否存在该用户
        User miniuser = userService.selectUserByOpenID(jsonObj.get("openid").toString());
        // 如果存在该用户
        if (miniuser != null) {
          // 将用户id返回
          res.put("userid", miniuser.getOpenid());
          return res;
        }
        // 如果是新用户，就添加用户到数据库中
        // 封装小程序对象
//        User userInfo = new User();
//        userInfo.setOpenid(jsonObj.get("openid").toString());
//        userInfo.setNickname(nickName);
//        userInfo.setImg(avatarUrl);
//        // 将用户信息保存到数据库中
//        userService.addUser(userInfo);

        // res.put("userid", miniuserService.isRegister(jsonObj.get("openid").toString()).getMini_id());

        res.put("userid", jsonObj.get("openid"));
        res.put("msg","USER_NOT_FOUND");
        return res;
    }

    /**
     * 小程序注册
     * @param request
     * @param openId
     * @param nickName 昵称
     * @param avatarUrl 头像
     * @return
     */
    @PostMapping("/miniReg")
    @ResponseBody
    public Map mini_Reg(HttpServletRequest request,@RequestParam("openId") String openId, @RequestParam("nickName") String nickName, @RequestParam("avatarUrl") String avatarUrl) {
        // String c=request.getParameter("code");//也可以通过此语句获取code值
        System.out.println(openId);
        System.out.println(nickName);
        System.out.println(avatarUrl);
        Map res = new HashMap();
        User userInfo = new User();
        userInfo.setOpenid(openId);
        userInfo.setNickname(nickName);
        userInfo.setImg(avatarUrl);
        // 将用户信息保存到数据库中
        userService.addUser(userInfo);

        res.put("userid", openId);
        res.put("msg","USER_NOT_FOUND");
        return res;
    }

    /**
     * 这里做的是一个假登录，假装调用学校提供的接口，验证登录者是否是我校学生/教师，
     * 如果验证通过，就去查询用户表里面有没有这个用户，如果没有，就存进去，再向user表中插入相关数据，将用户存进session，并且进入主界面，如果有，将用户存入session，进入主界面z
     * @param username 用户名
     * @param password 密码
     * @param session 存到session里面
     * @return
     */
    @RequestMapping(value = "/loginDo",method = {RequestMethod.POST})
    public  String loginDo(String username, String password, HttpSession session){
        Boolean isXHUer = userService.checkStatus(username,password);
        if (isXHUer){
            User user = userService.selectUserByOpenID(username);
            if(user != null){
                session.setAttribute("CUR_USER",user);
                return "main";
            }else{
                //user.setSnumber(username);
                Boolean isSuccess = userService.addUser(user);
                if(isSuccess){
                    session.setAttribute("CUR_USER",user);
                    return "main";
                }else{
                    return "redirect:/user/login.html";
                }
            }
        }else {
            return "redirect:/user/login.html";
        }
    }

    @RequestMapping("/mine.html")
    public String mine(){
        return "mine";
    }

    @RequestMapping("/mineDo")
    @ResponseBody
    public Result<User> mineDo(HttpSession session){
        User user = (User) session.getAttribute("CUR_USER");
        Result<User> result = new Result<>();
        result.setCode(Result.SUCCESS);
        result.setData(user);
        return result;
    }

    /**
     * 进入编辑用户界面
     * @return
     */
    @RequestMapping("/editUser.html")
    public String editUser(){
        return "editUser";
    }

    /**
     * 处理编辑用户的请求，将所有参数封装成一个User类，并上传新头像（如果做了更改的话），最后提交给service处理
     * @param session
     * @param nickname 昵称
     * @param img 新头像
     * @param contact 联系方式
     * @return
     */
    @RequestMapping("/editUserDo")
    public String editUserDo(HttpSession session, String nickname, @RequestParam("img")CommonsMultipartFile img,String contact){
        User user = (User) session.getAttribute("CUR_USER");
        user.setNickname(nickname);
        user.setContact(contact);
        if(img.isEmpty()){
           //user.setImg(user.getImg());
        }else{
            String fileName = img.getOriginalFilename();
            File dir = new File("D://images");
            if(!dir.exists()){
                dir.mkdirs();
            }
            String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
            File file = new File(dir,newFileName);
            try {
                //保存文件
                img.transferTo(file);
                CosClient.uploadFile(file,"headImg/"+newFileName);
                user.setImg(newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Boolean isSuccess = userService.editUser(user);
        return "mine";
    }
}
