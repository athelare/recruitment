package com.ctl.recruitment.pojo.result.data;

import com.ctl.recruitment.pojo.domain.ResumeEntity;

public class JobApplicationInfo {
    private Integer resumeId;
    private Integer jobId;
    private String studentName;
    private String jobName;
    private String companyName;
    private ResumeEntity.Status applicationStatus;

    public JobApplicationInfo(Integer resumeId, Integer jobId, String studentName, String jobName, String companyName, ResumeEntity.Status applicationStatus) {
        this.resumeId = resumeId;
        this.jobId = jobId;
        this.studentName = studentName;
        this.jobName = jobName;
        this.companyName = companyName;
        this.applicationStatus = applicationStatus;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getJobName() {
        return jobName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ResumeEntity.Status getApplicationStatus() {
        return applicationStatus;
    }
}
