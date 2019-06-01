package com.ctl.recruitment.pojo.result.data;

import com.ctl.recruitment.pojo.domain.JobEntity;

public class JobInfo {
    private Integer
            jobId,
            jobType,
            requireNum;
    private String
            jobName,
            companyId,
            jobCategory,

            companyName,
            place;

    public JobInfo(JobEntity jobEntity){
        setJobId(jobEntity.getJobId());
        setCompanyId(jobEntity.getCompanyByCompanyId().getCompanyId());
        setCompanyName(jobEntity.getCompanyByCompanyId().getName());
        setPlace(jobEntity.getCompanyByCompanyId().getAddress());
        setJobCategory(jobEntity.getType());
        setRequireNum(jobEntity.getRequireNum());
        setJobName(jobEntity.getJobName());
        setJobType(jobEntity.getWorkType());
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getRequireNum() {
        return requireNum;
    }

    public void setRequireNum(Integer requireNum) {
        this.requireNum = requireNum;
    }
}
