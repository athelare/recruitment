package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentDao extends JpaRepository<StudentEntity,Long> {

    @Modifying
    @Query(value = "INSERT INTO student(username,password) VALUE(:username, :password)",nativeQuery = true)
    void Register(String username,String password);

    StudentEntity findByUsername(String username);

    StudentEntity findByStudentId(String studentId);
}
