package com.ctl.recruitment.pojo.result.data;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ResumeStatusInfo {

    public static DateFormat df;
    static {
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }


    private Integer resumeId,jobId;
    private String createTime,companyName,jobName,Status;

    public ResumeStatusInfo(Integer resumeId, Integer jobId, String createTime, String companyName, String jobName, String status) {
        this.resumeId = resumeId;
        this.jobId = jobId;
        this.createTime = createTime;
        this.companyName = companyName;
        this.jobName = jobName;
        Status = status;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public String getStatus() {
        return Status;
    }
}
