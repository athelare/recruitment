package com.ctl.recruitment.pojo.result.data;

import java.util.List;

public class PostInfo {
    private Integer postId;
    private String username;
    private String content;
    private List<CommentInfo>comments;
    private String sendTime;

    /*经验贴*/
    public PostInfo(Integer postId, String username, String content, List<CommentInfo> comments, String sendTime) {
        this.postId = postId;
        this.username = username;
        this.content = content;
        this.comments = comments;
        this.sendTime = sendTime;
    }


    public Integer getPostId() {
        return postId;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public List<CommentInfo> getComments() {
        return comments;
    }
}