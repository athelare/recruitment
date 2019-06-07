package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public interface JobDao extends JpaRepository<JobEntity,Long> {

    JobEntity findByJobId(Integer jobId);

    @Query(value = "SELECT * FROM job INNER JOIN company c on job.company_id = c.company_id WHERE job.job_name LIKE :name AND c.city = :city",nativeQuery = true)
    List<JobEntity> findJobsByCityAndName(String city,String name);

    @Modifying
    @Query(value = "INSERT INTO job(company_id, job_name, require_num, detail, work_hour, app_deadline) VALUE (:companyId,:jobName,:requireNum,:detail,:workHour,:appDeadline)",nativeQuery = true)
    void createNewJob(String jobName, String companyId, Integer requireNum, String workHour, Date appDeadline, String detail);

    @Query(value = "SELECT COUNT(*) FROM job where company_id = :companyId",nativeQuery = true)
    Integer getCountByCompanyId(String companyId);

    @Query(value = "SELECT * FROM job WHERE company_id = :companyId ORDER BY job_id DESC LIMIT :bg,:size ",nativeQuery = true)
    List<JobEntity>findByCompanyId(String companyId,Integer bg,Integer size);
}
