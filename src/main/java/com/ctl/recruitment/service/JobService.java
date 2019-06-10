package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.domain.JobEntity;
import com.ctl.recruitment.pojo.result.data.JobInfo;

import java.util.List;

public interface JobService {
    JobEntity findByJobId(Integer jobId);
    List<JobInfo> findJobsByCityAndName(String city,String name);
}
