package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ResumeDao extends JpaRepository<ResumeEntity,Long> {

    ResumeEntity findByResumeId(Integer resumeId);

    @Query(nativeQuery = true,value = "SELECT MAX(resume_id) FROM resume")
    Integer getNewResumeIndex();

    List<ResumeEntity> findByStudentUsername(String username);

    /*处理职位申请，待处理申请，正在处理申请，已处理申请，全部申请四种类型*/
    /*全部申请*/
    @Query(value = "SELECT resume.* FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId LIMIT :bg,:sz",nativeQuery = true)
    List<ResumeEntity>findAllByCompanyId(String companyId,Integer bg,Integer sz);

    @Query(value = "SELECT resume.* FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId AND resume.status = 'PENDING' LIMIT :bg,:sz",nativeQuery = true)
    List<ResumeEntity>findPendingByCompanyId(String companyId,Integer bg,Integer sz);

    @Query(value = "SELECT resume.* FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId AND resume.status = 'PROCESSING' LIMIT :bg,:sz",nativeQuery = true)
    List<ResumeEntity>findProcessingByCompanyId(String companyId,Integer bg,Integer sz);

    @Query(value = "SELECT resume.* FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId AND resume.status = 'FINISHED' LIMIT :bg,:sz",nativeQuery = true)
    List<ResumeEntity>findFinishedByCompanyId(String companyId,Integer bg,Integer sz);

    /*统计个数*/
    @Query(value = "SELECT COUNT(resume.resume_id) FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId",nativeQuery = true)
    Integer countAllByCompanyId(String companyId);

    @Query(value = "SELECT COUNT(resume.resume_id) FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId AND resume.status = 'PENDING'",nativeQuery = true)
    Integer countPendingByCompanyId(String companyId);

    @Query(value = "SELECT COUNT(resume.resume_id) FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId AND resume.status = 'PROCESSING'",nativeQuery = true)
    Integer countProcessingByCompanyId(String companyId);

    @Query(value = "SELECT COUNT(resume.resume_id) FROM resume INNER JOIN job j on resume.job_id = j.job_id WHERE j.company_id = :companyId AND resume.status = 'FINISHED'",nativeQuery = true)
    Integer countFinishedByCompanyId(String companyId);



}
