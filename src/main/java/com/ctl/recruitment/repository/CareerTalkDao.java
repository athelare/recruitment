package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.CareerTalkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerTalkDao extends JpaRepository<CareerTalkEntity,Long> {
    @Query(value = "SELECT career_talk.* FROM career_talk INNER JOIN follow ON career_talk.company_id = follow.company_id AND follow.student_username = :username",nativeQuery = true)
    List<CareerTalkEntity> findByUsername(String username);
}
