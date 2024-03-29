package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import com.ctl.recruitment.pojo.domain.StudentEntity;
import com.ctl.recruitment.pojo.result.data.CareerTalkInfo;
import com.ctl.recruitment.pojo.result.data.MyFollowingCompanyInfo;
import com.ctl.recruitment.pojo.result.data.StudentInfo;

import java.util.List;

public interface StudentService {
    StudentEntity findByStudentUsername(String username);
    StudentEntity StudentRegister(String username, String password);
    Integer findNewResumeIndex();
    void saveResume(ResumeEntity resume);
    void saveStudentInfo(StudentEntity studentEntity);
    List<ResumeEntity> findResumesByUsername(String username);
    void addFollow(String username,String companyId);
    void deleteFollow(String username,String companyId);
    List<MyFollowingCompanyInfo> showFollow(String username);
    List<CareerTalkInfo> findCareerTalks(String username);
    ResumeEntity findByResumeId(Integer resumeId);
    void deleteByResumeId(Integer resumeId);
    boolean isFollow(String username,String companyId);
    List<StudentInfo> findUnverified();
    List<StudentInfo> findVerified();
}
