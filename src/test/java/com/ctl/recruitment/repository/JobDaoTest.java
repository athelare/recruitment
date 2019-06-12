package com.ctl.recruitment.repository;

import com.ctl.recruitment.RecruitmentApplicationTests;
import com.ctl.recruitment.pojo.domain.JobEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class JobDaoTest extends RecruitmentApplicationTests {

    @Autowired JobDao jobDao;

    @Test
    public void findByType() {
        for(JobEntity j:jobDao.findByType("软件")){
            System.out.println(j.getJobName());
        }
    }
}