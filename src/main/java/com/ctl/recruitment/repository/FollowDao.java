package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowDao extends JpaRepository<FollowEntity,Long> {
}