package com.lsk.controller;

import com.lsk.dto.Result;
import com.lsk.entity.*;
import com.lsk.service.PostService;
import com.lsk.util.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author LSKun
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;


    /**
     * 跳转到post界面
     * @return
     * @date 2021-04-19 10:24:48
     */
    @RequestMapping("/post.html")
    public String jumpToPost(){
        return "post";
    }

    /**
     * 跳转到发布帖子的界面
     * @return
     * @date 2021-04-19 10:48:12
     */
    @RequestMapping("/releasePost.html")
    public String jumpToReleasePost(){
        return "releasePost";
    }

    /**
     * 发布求购信息
     * @param session
     * @param content
     * @return
     * @date 2021-04-19 10:42:23
     */
    @RequestMapping("/releasePost")
    @ResponseBody
    public Boolean releasePost(HttpSession session,String content,String postImg,String uid){
        //User user = (User) session.getAttribute("CUR_USER");
        PostInfo postInfo = new PostInfo();
        postInfo.setPoster(Integer.parseInt(uid));
        postInfo.setPostcontent(content);
        postInfo.setViews(0);
        if (!"".equals(postImg)){
            postInfo.setPostimg(postImg);
        }
        postInfo.setPosttime(new Timestamp(System.currentTimeMillis()));
        boolean isSuccess = postService.addPostInfo(postInfo);
        return isSuccess;
    }


    /**
     * 获取帖子列表信息
     * @return
     * @date 2021-04-20 10:27:15
     */
    @RequestMapping("/getPosts")
    @ResponseBody
    public Result<List<ComplexPostInfo>> getPosts(){
        List<ComplexPostInfo> list = postService.getPosts("0");
        Result<List<ComplexPostInfo>> result = new Result<>();
        result.setData(list);
        result.setCode(list != null ? Result.SUCCESS : Result.ERROR);
        return result;
    }

    /**
     * 跳转到帖子详情界面
     * @return
     * @date 2021-04-20 16:09:55
     */
    @RequestMapping("/postPage.html")
    public String commentToPost(){
        return "postPage";
    }

    /**
     * 获取帖子详细信息，并将帖子浏览量+1
     * @param postid
     * @return
     * @date 2021-04-20 16:28:54
     */
    @RequestMapping("/getPostInfo")
    @ResponseBody
    public Result<ComplexPostInfo> getPostInfo(String postid){
        ComplexPostInfo postInfo = postService.getComplexPostInfo(Integer.parseInt(postid));
        Result<ComplexPostInfo> result = new Result<>();
        result.setData(postInfo);
        result.setCode(postInfo != null ? Result.SUCCESS : Result.ERROR);
        return result;
    }

//    /**
//     * 发表对帖子的评论
//     * @param session
//     * @param reviewContent
//     * @param postid
//     * @return
//     * @date 2021-04-20 20:03:48
//     */
//    @RequestMapping("/commentToPost")
//    @ResponseBody
//    public Boolean commentToPost(HttpSession session,String reviewContent,String postid){
//        User user = (User) session.getAttribute("CUR_USER");
//        Review review = new Review();
//        review.setReviewer(user.getUid());
//        review.setViewobject(0);
//        review.setObjectid(Integer.parseInt(postid));
//        review.setReviewcontent(reviewContent);
//        review.setReviewtime(new Timestamp(System.currentTimeMillis()));
//        review.setPostid(Integer.parseInt(postid));
//
//
//        boolean isSuccess = postService.insertView(review);
//        return isSuccess;
//    }

    /**
     * 发表对帖子或者帖子下的用户的评论
     * @param userId 评论人的id
     * @param reviewContent
     * @param uid 用户（被评论人的）id
     * @param postid 帖子id
     * @param nickname 被评论用户的nickname，如果评论的是帖子，就可以为空
     * @param viewObject 为0，表示评论对象为帖子，为1，表示评论对象为用户
     * @return
     * @date 2021-04-20 20:19:38
     */
    @RequestMapping("/comment")
    @ResponseBody
    public Boolean comment(String userId,String reviewContent,String uid,String postid,String nickname,String viewObject){
        Review review = new Review();
        review.setReviewer(Integer.parseInt(userId));
        review.setViewobject(Integer.parseInt(viewObject));
        if(viewObject.equals("1")){
            review.setObjectid(Integer.parseInt(uid));
        }else{
            review.setObjectid(Integer.parseInt(postid));
        }
        review.setReviewcontent(reviewContent);
        review.setReviewtime(new Timestamp(System.currentTimeMillis()));
        review.setPostid(Integer.parseInt(postid));
        System.out.println("nickname: " + nickname);
        review.setObjectname(nickname);

        boolean isSuccess = postService.insertView(review);
        return isSuccess;
    }

    /**
     * 获取评论
     * 直接获取帖子下所有的评论（分页），按照时间先后排序，如果viewobject为0.则是对帖子的评论，如果为1，则是对帖子下发表评论的用户的评论，这时候就需要根据object查询用户，在前端做对应的渲染
     * @param postid
     * @return
     * @date 2021-04-20 20:09:27
     */
    @RequestMapping("/getReview")
    @ResponseBody
    public Result<List<ComplexReview>> getReview(String postid){
        List<ComplexReview> list = postService.getReview(Integer.parseInt(postid));
        Result<List<ComplexReview>> result = new Result<>();
        for(ComplexReview review:list){
            System.out.println(review);
        }
        result.setData(list);
        result.setCode(list != null ? Result.SUCCESS : Result.ERROR);
        return result;
    }
}
