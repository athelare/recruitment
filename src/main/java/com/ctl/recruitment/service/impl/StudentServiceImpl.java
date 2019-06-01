package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.pojo.domain.StudentEntity;
import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.repository.StudentDao;
import com.ctl.recruitment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public ResultType StudentRegister(String username, String password) {
        StudentEntity student = new StudentEntity();
        student.setStudentId(username);
        student.setPassword(password);
        try{
            studentDao.save(student);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("未能成功注册");
        }
    }
}
