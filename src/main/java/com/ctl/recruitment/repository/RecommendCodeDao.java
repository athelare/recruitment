package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.RecommendCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RecommendCodeDao extends JpaRepository<RecommendCodeEntity, Long> {

    @Query(value = "SELECT recommend_code.* FROM recommend_code INNER JOIN student s on recommend_code.student_username = s.username WHERE university_name = :university",nativeQuery = true)
    List<RecommendCodeEntity>findByUniversityName(String university);

    @Modifying
    @Query(value = "INSERT INTO recommend_code(company_id, recommend_code, student_username) value (:companyId,:recommendCode,:username)",nativeQuery = true)
    void addRecommendCode(String username,String companyId,String recommendCode);

}
