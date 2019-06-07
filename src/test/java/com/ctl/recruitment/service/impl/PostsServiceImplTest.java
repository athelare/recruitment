package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.RecruitmentApplicationTests;
import com.ctl.recruitment.service.PostsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PostsServiceImplTest extends RecruitmentApplicationTests {

    @Autowired
    PostsService postsService;

    @Test
    public void showPosts() {
        postsService.showPosts();
    }
}