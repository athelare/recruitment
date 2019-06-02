package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ResumeDao extends JpaRepository<ResumeEntity,Long> {

    @Query(nativeQuery = true,value = "SELECT MAX(resume_id) FROM resume")
    Integer getNewResumeIndex();

    List<ResumeEntity> findByStudentUsername(String username);
}
