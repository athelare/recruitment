package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import com.ctl.recruitment.pojo.domain.StudentEntity;
import com.ctl.recruitment.pojo.result.data.CareerTalkInfo;
import com.ctl.recruitment.pojo.result.data.MyFollowingCompanyInfo;

import java.util.List;

public interface StudentService {
    StudentEntity findByStudentUsername(String username);
    StudentEntity StudentRegister(String username, String password);
    Integer saveResume(ResumeEntity resume);
    void saveStudentInfo(StudentEntity studentEntity);
    List<ResumeEntity> findResumesByUsername(String username);
    void addFollow(String username,String companyId);
    void deleteFollow(String username,String companyId);
    List<MyFollowingCompanyInfo> showFollow(String username);
    List<CareerTalkInfo> findCareerTalks(String username);

}
