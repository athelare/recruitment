package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.pojo.domain.CareerTalkEntity;
import com.ctl.recruitment.pojo.domain.CompanyEntity;
import com.ctl.recruitment.pojo.domain.ResumeEntity;
import com.ctl.recruitment.pojo.domain.StudentEntity;
import com.ctl.recruitment.pojo.result.data.CareerTalkInfo;
import com.ctl.recruitment.pojo.result.data.MyFollowingCompanyInfo;
import com.ctl.recruitment.pojo.result.data.StudentInfo;
import com.ctl.recruitment.repository.*;
import com.ctl.recruitment.service.StudentService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;
    private final ResumeDao resumeDao;
    private final FollowDao followDao;
    private final CompanyDao companyDao;
    private final CareerTalkDao careerTalkDao;

    public StudentServiceImpl(StudentDao studentDao, ResumeDao resumeDao, FollowDao followDao, CompanyDao companyDao, CareerTalkDao careerTalkDao) {
        this.studentDao = studentDao;
        this.resumeDao = resumeDao;
        this.followDao = followDao;
        this.companyDao = companyDao;
        this.careerTalkDao = careerTalkDao;
    }

    @Override
    public StudentEntity findByStudentUsername(String username) {
        return studentDao.findByUsername(username);
    }

    @Override
    public StudentEntity StudentRegister(String username, String password) {
        studentDao.Register(username,password);
        return studentDao.findByUsername(username);

    }

    @Override
    public Integer findNewResumeIndex() {
        return resumeDao.getNewResumeIndex();
    }

    @Override
    public void saveResume(ResumeEntity resume) {
        resumeDao.save(resume);
        resumeDao.getNewResumeIndex();
    }

    @Override
    public void saveStudentInfo(StudentEntity studentEntity) {
        studentDao.save(studentEntity);
    }

    @Override
    public List<ResumeEntity> findResumesByUsername(String username) {
        return resumeDao.findByStudentUsername(username);
    }

    @Override
    public void addFollow(String username, String companyId) {
        if(null == followDao.findByUsernameAndCompanyId(username,companyId))
            followDao.addFollow(username,companyId);
    }

    @Override
    public void deleteFollow(String username, String companyId) {
        followDao.deleteFollow(username,companyId);
    }

    @Override
    public List<MyFollowingCompanyInfo> showFollow(String username) {
        List<CompanyEntity> companyEntities = companyDao.showFollowedCompany(username);
        List<MyFollowingCompanyInfo> res= new ArrayList<>();
        for(CompanyEntity c:companyEntities){
            res.add(new MyFollowingCompanyInfo(c.getCompanyId(), c.getName(),new Date(followDao.findByUsernameAndCompanyId(username,c.getCompanyId()).getFollowDate().getTime())));
        }
        return res;
    }

    @Override
    public List<CareerTalkInfo> findCareerTalks(String username) {
        List<CareerTalkEntity> talks =  careerTalkDao.findByUsername(username);
        List<CareerTalkInfo> res = new ArrayList<>();
        for(CareerTalkEntity t:talks){
            res.add(
                    new CareerTalkInfo(t.getCompany().getName(),t.getPlace(),t.getHeldTime())
            );
        }

        return res;
    }

    @Override
    public ResumeEntity findByResumeId(Integer resumeId) {
        return resumeDao.findByResumeId(resumeId);
    }

    @Override
    public void deleteByResumeId(Integer resumeId) {
        resumeDao.deleteByResumeId(resumeId);
    }

    @Override
    public boolean isFollow(String username, String companyId) {
        return followDao.countFollow(username,companyId)>0;
    }


    @Override
    public List<StudentInfo> findUnverified() {
        List<StudentInfo> res = new ArrayList<>();
        for(StudentEntity s:studentDao.findByVerified(new Byte("0"))){
            res.add(new StudentInfo(
                    s.getUsername(),
                    s.getRealName(),
                    s.getUniversityName(),
                    s.getPhone(),
                    s.getEmail(),
                    s.getPortrait()
            ));
        }
        return res;
    }

    @Override
    public List<StudentInfo> findVerified() {
        List<StudentInfo> res = new ArrayList<>();
        for(StudentEntity s:studentDao.findByVerified(new Byte("1"))){
            res.add(new StudentInfo(
                    s.getUsername(),
                    s.getRealName(),
                    s.getUniversityName(),
                    s.getPhone(),
                    s.getEmail(),
                    s.getPortrait()
            ));
        }
        return res;
    }
}
