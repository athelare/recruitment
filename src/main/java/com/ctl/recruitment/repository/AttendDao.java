package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.AttendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendDao extends JpaRepository<AttendEntity,Long> {
}
