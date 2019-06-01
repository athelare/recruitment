package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends JpaRepository<CompanyEntity,Long> {
    List<CompanyEntity>findByCityAndNameLike(String address,String name);
}
