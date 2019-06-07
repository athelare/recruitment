package com.ctl.recruitment.pojo.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "job", schema = "campus_recruitment")
public class JobEntity {
    private int jobId;
    private String jobName;
    private String type;
    private Integer requireNum;
    private String detail;
    private CompanyEntity companyByCompanyId;
    private Integer workType;
    private String workHour;
    private Date appDeadline;

    @Id
    @Column(name = "job_id", nullable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_name", length = 30)
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "type", length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "require_num")
    public Integer getRequireNum() {
        return requireNum;
    }

    public void setRequireNum(Integer requireNum) {
        this.requireNum = requireNum;
    }

    @Basic
    @Column(name = "detail")
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

    @Basic
    @Column(name = "work_hour", length = 40)
    public String getWorkHour() {
        return workHour;
    }

    public void setWorkHour(String workHour) {
        this.workHour = workHour;
    }

    @Basic
    @Column(name = "app_deadline", nullable = true)
    public Date getAppDeadline() {
        return appDeadline;
    }

    public void setAppDeadline(Date appDeadline) {
        this.appDeadline = appDeadline;
    }
}
