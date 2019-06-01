package com.ctl.recruitment.service;

import com.ctl.recruitment.pojo.result.data.CompanyInfo;

import java.util.List;

public interface CompanyService {
    List<CompanyInfo> findCompaniesByCityAndName(String city,String name);
}
