package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.CareerTalkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerTalkDao extends JpaRepository<CareerTalkEntity,Long> {
}
