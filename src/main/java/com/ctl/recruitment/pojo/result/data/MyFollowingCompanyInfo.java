package com.ctl.recruitment.pojo.result.data;

import java.sql.Date;

public class MyFollowingCompanyInfo {
    private String companyName;
    private Date followDate;

    public MyFollowingCompanyInfo(String companyName, Date followDate) {
        this.companyName = companyName;
        this.followDate = followDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getFollowDate() {
        return followDate;
    }
}
