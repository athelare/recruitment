package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FollowDao extends JpaRepository<FollowEntity,Long> {
    @Modifying
    @Query(value = "INSERT INTO follow(student_username, company_id) VALUE (:studentUsername,:companyId) ",nativeQuery = true)
    void addFollow(String studentUsername,String companyId);

    @Modifying
    @Query(value = "DELETE FROM follow WHERE student_username = :studentUsername AND company_id = :companyId ",nativeQuery = true)
    void deleteFollow(String studentUsername,String companyId);

    @Query(value = "SELECT * FROM follow WHERE student_username = :username AND company_id = :companyId",nativeQuery = true)
    FollowEntity findByUsernameAndCompanyId(String username,String companyId);
}
