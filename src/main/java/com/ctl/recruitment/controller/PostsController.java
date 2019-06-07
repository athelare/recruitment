package com.ctl.recruitment.controller;

import com.ctl.recruitment.pojo.domain.StudentEntity;
import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.service.PostsService;
import com.ctl.recruitment.util.ExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping("/show/experience")
    public ResultType showPosts(){
        try {
            return ResultType.Success(postsService.showPosts());
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server: 未能查找经验贴。\n"+ ExceptionUtil.getExceptionInformation(e));
        }
    }

    @RequestMapping("/show/recommend-code")
    public ResultType showRecommendCodes(HttpServletRequest request){
        try {
            String username = ((StudentEntity)request.getSession().getAttribute("loginUser")).getUsername();
            return ResultType.Success(postsService.showRecommendCodes(username));
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server: 未能查找内推贴。\n"+ ExceptionUtil.getExceptionInformation(e));
        }
    }

    @RequestMapping("/new/post")
    public ResultType addPost(HttpServletRequest request, @RequestParam String content){
        try {
            String username = ((StudentEntity)request.getSession().getAttribute("loginUser")).getUsername();
            postsService.addPost(username,content);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server: 未能发布新帖子。\n"+ ExceptionUtil.getExceptionInformation(e));
        }
    }

    @RequestMapping("/new/recommend-code")
    public ResultType addRecommendCode(HttpServletRequest request,@RequestParam String companyId,@RequestParam String recommendCode){
        try {
            String username = ((StudentEntity)request.getSession().getAttribute("loginUser")).getUsername();
            postsService.addRecommendCode(username,companyId,recommendCode);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server: 未能发布内推贴。\n"+ ExceptionUtil.getExceptionInformation(e));
        }
    }

    @RequestMapping("/new/comment")
    public ResultType addComment(HttpServletRequest request, Integer postId, String content){
        try{
            String username = ((StudentEntity)request.getSession().getAttribute("loginUser")).getUsername();
            postsService.addComment(postId, username, content);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("未能新增评论\n"+ ExceptionUtil.getExceptionInformation(e));
        }
    }

}
