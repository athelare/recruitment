package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.pojo.domain.CompanyEntity;
import com.ctl.recruitment.pojo.result.data.CompanyInfo;
import com.ctl.recruitment.repository.CompanyDao;
import com.ctl.recruitment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Override
    public List<CompanyInfo> findCompaniesByCityAndName(String city, String name) {
        List<CompanyInfo> res = new ArrayList<>();
        for(CompanyEntity c:companyDao.findByCityAndNameLike(city,'%'+name+'%')){
            res.add(new CompanyInfo(c));
        }
        return res;
    }
}
