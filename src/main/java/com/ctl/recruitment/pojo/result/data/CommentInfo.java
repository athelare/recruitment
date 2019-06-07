package com.ctl.recruitment.pojo.result.data;

public class CommentInfo{
    public CommentInfo(Integer commentId, String username, String content) {
        this.commentId = commentId;
        this.username = username;
        this.content = content;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    private Integer commentId;
    private String username;
    private String content;
}