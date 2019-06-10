package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.pojo.domain.JobEntity;
import com.ctl.recruitment.pojo.result.data.JobInfo;
import com.ctl.recruitment.repository.JobDao;
import com.ctl.recruitment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobServiceImpl implements JobService {

    @Autowired
    JobDao jobDao;

    @Override
    public JobEntity findByJobId(Integer jobId) {
        return jobDao.findByJobId(jobId);
    }

    @Override
    public List<JobInfo> findJobsByCityAndName(String city, String name) {
        List<JobEntity>jobEntities = jobDao.findJobsByCityAndName(city,'%'+name+'%') ;
        List<JobInfo> jobInfoList = new ArrayList<>();
        for(JobEntity jobEntity:jobEntities){
            JobInfo job = new JobInfo(jobEntity);
            jobInfoList.add(job);
        }
        return jobInfoList;
    }
}
