package com.ctl.recruitment.pojo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "job", schema = "campus_recruitment")
public class JobEntity {
    private int jobId;
    private String jobName;
    private String type;
    private Integer requireNum;
    private String detail;
    private CompanyEntity companyByCompanyId;
    private Integer workType;

    @Id
    @Column(name = "job_id", nullable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_name", nullable = true, length = 30)
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "require_num", nullable = true)
    public Integer getRequireNum() {
        return requireNum;
    }

    public void setRequireNum(Integer requireNum) {
        this.requireNum = requireNum;
    }

    @Basic
    @Column(name = "detail", nullable = true, length = 255)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobEntity jobEntity = (JobEntity) o;
        return jobId == jobEntity.jobId &&
                Objects.equals(jobName, jobEntity.jobName) &&
                Objects.equals(type, jobEntity.type) &&
                Objects.equals(requireNum, jobEntity.requireNum) &&
                Objects.equals(detail, jobEntity.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobName, type,  requireNum, detail);
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    @Basic
    @Column(name = "work_type", nullable = true)
    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
}
