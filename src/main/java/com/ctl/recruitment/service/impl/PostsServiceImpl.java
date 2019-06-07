package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.pojo.domain.RecommendCodeEntity;
import com.ctl.recruitment.pojo.domain.StudentCommentEntity;
import com.ctl.recruitment.pojo.domain.StudentPostEntity;
import com.ctl.recruitment.pojo.result.data.CommentInfo;
import com.ctl.recruitment.pojo.result.data.PostInfo;
import com.ctl.recruitment.pojo.result.data.RecommendCodeInfo;
import com.ctl.recruitment.repository.PostDao;
import com.ctl.recruitment.repository.RecommendCodeDao;
import com.ctl.recruitment.repository.StudentDao;
import com.ctl.recruitment.service.PostsService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    private static DateFormat df;
    static {
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    private final PostDao postDao;
    private final StudentDao studentDao;
    private final RecommendCodeDao recommendCodeDao;

    public PostsServiceImpl(PostDao postDao, StudentDao studentDao, RecommendCodeDao recommendCodeDao) {
        this.postDao = postDao;
        this.studentDao = studentDao;
        this.recommendCodeDao = recommendCodeDao;
    }

    @Override
    public List<PostInfo> showPosts() {
        List<StudentPostEntity> postEntities =  postDao.findAll();
        List<PostInfo> res = new ArrayList<>();
        for(StudentPostEntity p:postEntities){
            Collection<StudentCommentEntity> commentEntities = p.getComments();
            List<CommentInfo> commentInfos=new ArrayList<>();
            for(StudentCommentEntity c:commentEntities){
                commentInfos.add(new CommentInfo(c.getCommentId(),c.getStudentUsername(),c.getContent())); }

            res.add(new PostInfo(
                    p.getPostId(),
                    p.getStudentByAuthor().getUsername(),
                    p.getContent(),
                    commentInfos,
                    df.format(p.getPostTime()))); }
        return res;
    }

    @Override
    public List<RecommendCodeInfo> showRecommendCodes(String username) {
        String university = studentDao.findByUsername(username).getUniversityName();
        List<RecommendCodeEntity> codeEntities = recommendCodeDao.findByUniversityName(university);
        List<RecommendCodeInfo> res = new ArrayList<>();
        for(RecommendCodeEntity r:codeEntities){
            res.add(new RecommendCodeInfo(
                    r.getCompanyByCompanyId().getCompanyId(),
                    r.getCompanyByCompanyId().getWebsite(),
                    r.getStudentUsername(),
                    r.getRecommendCode())); }
        return res;
    }

    @Override
    public void addPost(String username, String content) {
        postDao.addPost(username,content);
    }

    @Override
    public void addRecommendCode(String username, String companyId, String code) {
        recommendCodeDao.addRecommendCode(username, companyId, code);
    }

    @Override
    public void addComment(Integer postId, String username, String content) {
        postDao.addComment(postId, username,content);
    }
}
