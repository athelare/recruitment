package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.result.ResultType;

public interface StudentService {
    ResultType StudentRegister(String username, String password);
}
