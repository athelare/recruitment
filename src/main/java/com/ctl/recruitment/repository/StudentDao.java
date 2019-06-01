package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity,Long> {

}
