package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.result.data.PostInfo;
import com.ctl.recruitment.pojo.result.data.RecommendCodeInfo;

import java.util.List;

public interface PostsService {
    List<PostInfo>showPosts();
    List<RecommendCodeInfo>showRecommendCodes(String username);
    void addPost(String username,String content);
    void addRecommendCode(String username,String companyId,String recommendCode);
    void addComment(Integer postId,String username,String content);
}
