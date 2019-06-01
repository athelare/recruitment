package com.ctl.recruitment.pojo.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "student_post", schema = "campus_recruitment")
public class StudentPostEntity {
    enum Type{EXPERIENCE,RECOMMEND_CODE}
    private int postId;
    private String title;
    private Type type;
    private String content;
    private Timestamp postTime;
    private StudentEntity studentByAuthor;

    @Id
    @Column(name = "post_id", nullable = false)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = true)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "post_time", nullable = true)
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
                Objects.equals(title, that.title) &&
                Objects.equals(type, that.type) &&
                Objects.equals(content, that.content) &&
                Objects.equals(postTime, that.postTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, title, type, content, postTime);
    }

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "student_id")
    public StudentEntity getStudentByAuthor() {
        return studentByAuthor;
    }

    public void setStudentByAuthor(StudentEntity studentByAuthor) {
        this.studentByAuthor = studentByAuthor;
    }
}
