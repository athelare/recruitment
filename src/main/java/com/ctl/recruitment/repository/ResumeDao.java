package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDao extends JpaRepository<ResumeEntity,Long> {
}
