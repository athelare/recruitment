package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.StudentPostEntity;
import org.hibernate.event.spi.PostDeleteEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PostDao extends JpaRepository<StudentPostEntity,Long> {

    @Modifying
    @Query(value = "INSERT INTO student_post(author, content) VALUE (:username, :content)",nativeQuery = true)
    void addPost(String username,String content);


    @Modifying
    @Query(value = "INSERT INTO student_comment(student_username, content, post_id) VALUE (:username, :content, :postId)",nativeQuery = true)
    void addComment(Integer postId, String username, String content);

}
