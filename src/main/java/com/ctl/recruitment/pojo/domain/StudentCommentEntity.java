package com.ctl.recruitment.pojo.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "student_comment", schema = "campus_recruitment")
public class StudentCommentEntity {
    private Integer commentId;
    private String studentUsername;
    private String content;
    private StudentPostEntity studentPostByPostId;

    @Id
    @Column(name = "comment_id", nullable = false)
    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "student_username", nullable = false, length = 20)
    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCommentEntity that = (StudentCommentEntity) o;
        return Objects.equals(commentId, that.commentId) &&
                Objects.equals(studentUsername, that.studentUsername) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, studentUsername, content);
    }

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    public StudentPostEntity getStudentPostByPostId() {
        return studentPostByPostId;
    }

    public void setStudentPostByPostId(StudentPostEntity studentPostByPostId) {
        this.studentPostByPostId = studentPostByPostId;
    }
}
