package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import com.ctl.recruitment.pojo.domain.StudentEntity;
import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.pojo.result.data.CareerTalkInfo;
import com.ctl.recruitment.pojo.result.data.MyFollowingCompanyInfo;
import com.ctl.recruitment.pojo.result.data.StudentInfo;

import java.util.List;

public interface StudentService {
    StudentEntity findByStudentId(String studentId);
    StudentEntity findByStudentUsername(String username);
    StudentEntity StudentRegister(String username, String password);
    void StudentValidate(String username, String name,String identity,String address,String university,String enrollYear,String college,String studentId);
    Integer saveResume(ResumeEntity resume);
    void saveStudentInfo(StudentEntity studentEntity);
    List<ResumeEntity> findResumesByUsername(String username);
    StudentInfo getPersonalInfo(String username);
    void addFollow(String username,String companyId);
    void deleteFollow(String username,String companyId);
    List<MyFollowingCompanyInfo> showFollow(String username);
    List<CareerTalkInfo> findCareerTalks(String username);

}
