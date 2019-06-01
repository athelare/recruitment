package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao extends JpaRepository<JobEntity,Long> {

    @Query(value = "SELECT * FROM job INNER JOIN company c on job.company_id = c.company_id WHERE job.job_name LIKE :name AND c.city = :city",nativeQuery = true)
    List<JobEntity> findJobsByCityAndName(String city,String name);
}
