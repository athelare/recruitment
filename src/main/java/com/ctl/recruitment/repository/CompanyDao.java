package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CompanyDao extends JpaRepository<CompanyEntity,Long> {
    List<CompanyEntity>findByCityAndNameLike(String address,String name);

    @Query(value = "SELECT company.* FROM company INNER JOIN follow f on company.company_id = f.company_id AND f.student_username = :username",nativeQuery = true)
    List<CompanyEntity> showFollowedCompany(String username);

    CompanyEntity findByCompanyId(String companyId);
}
