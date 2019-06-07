package com.ctl.recruitment.pojo.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "student_post", schema = "campus_recruitment")
public class StudentPostEntity {
    private int postId;
    private String content;
    private Timestamp postTime;
    private StudentEntity studentByAuthor;
    private Collection<StudentCommentEntity> Comments;

    @Id
    @Column(name = "post_id", nullable = false)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


    @Basic
    @Column(name = "content", length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "post_time")
    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPostEntity that = (StudentPostEntity) o;
        return postId == that.postId &&
                Objects.equals(content, that.content) &&
                Objects.equals(postTime, that.postTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, content, postTime);
    }

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "username")
    public StudentEntity getStudentByAuthor() {
        return studentByAuthor;
    }

    public void setStudentByAuthor(StudentEntity studentByAuthor) {
        this.studentByAuthor = studentByAuthor;
    }

    @OneToMany(mappedBy = "studentPostByPostId")
    public Collection<StudentCommentEntity> getComments() {
        return Comments;
    }

    public void setComments(Collection<StudentCommentEntity> comments) {
        Comments = comments;
    }

}
