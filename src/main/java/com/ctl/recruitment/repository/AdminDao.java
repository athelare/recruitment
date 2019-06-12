package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AdminDao extends JpaRepository<AdministratorEntity,Long> {
    AdministratorEntity findByAdminUsername(String username);

    @Modifying
    @Query(value = "UPDATE student SET verified = 1 WHERE username = :username",nativeQuery = true)
    public void passStudent(String username);

    @Modifying
    @Query(value = "UPDATE company SET verified = 1 WHERE company_id = :username",nativeQuery = true)
    public void passCompany(String username);
}
