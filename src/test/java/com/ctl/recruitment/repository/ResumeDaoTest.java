package com.ctl.recruitment.repository;

import com.ctl.recruitment.RecruitmentApplicationTests;
import com.ctl.recruitment.pojo.domain.ResumeEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ResumeDaoTest extends RecruitmentApplicationTests {

    @Autowired ResumeDao resumeDao;

    @Test
    public void findAllByCompanyId() {
        for(ResumeEntity r:resumeDao.findAllByCompanyId("10010011",0,10)){
            System.out.println(r.getResumeId());
        }
    }

    @Test
    public void findPendingByCompanyId() {
        for(ResumeEntity r:resumeDao.findPendingByCompanyId("10010011",0,10)){
            System.out.println(r.getResumeId());
        }
    }

    @Test
    public void findProcessingByCompanyId() {
        for(ResumeEntity r:resumeDao.findProcessingByCompanyId("10010011",0,10)){
            System.out.println(r.getResumeId());
        }
    }

    @Test
    public void findFinishedByCompanyId() {
        for(ResumeEntity r:resumeDao.findFinishedByCompanyId("10010011",0,10)){
            System.out.println(r.getResumeId());
        }
    }

    @Test
    public void countAllByCompanyId() {
        System.out.println(resumeDao.countAllByCompanyId("10010011"));
    }

    @Test
    public void countPendingByCompanyId() {
        System.out.println(resumeDao.countPendingByCompanyId("10010011"));
    }

    @Test
    public void countProcessingCompanyId() {
        System.out.println(resumeDao.countProcessingByCompanyId("10010011"));
    }

    @Test
    public void countFinishedByCompanyId() {
        System.out.println(resumeDao.countFinishedByCompanyId("10010011"));
    }
}