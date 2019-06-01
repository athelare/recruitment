package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.result.data.JobInfo;

import java.util.List;

public interface JobService {
    List<JobInfo> findJobsByCityAndName(String city,String name);
}
