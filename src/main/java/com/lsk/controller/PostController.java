package com.lsk.controller;

import com.lsk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LSKun
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;
}
