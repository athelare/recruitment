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
        this.jobId = jobEntity.getJobId();
        this.companyId = jobEntity.getCompanyByCompanyId().getCompanyId();
        this.companyName = jobEntity.getCompanyByCompanyId().getName();
        this.place = jobEntity.getCompanyByCompanyId().getAddress();
        this.jobCategory = jobEntity.getType();
        this.requireNum = jobEntity.getRequireNum();
        this.jobName = jobEntity.getJobName();
        this.jobType = jobEntity.getWorkType();
    }

    public Integer getJobId() {
        return jobId;
    }
    public String getCompanyId() {
        return companyId;
    }
    public String getJobName() {
        return jobName;
    }
    public Integer getJobType() {
        return jobType;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getPlace() {
        return place;
    }
    public Integer getRequireNum() {
        return requireNum;
    }
    public String getJobCategory() {
        return jobCategory;
    }
}
