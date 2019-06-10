package com.ctl.recruitment.pojo.result.data;

import java.sql.Date;

public class MyFollowingCompanyInfo {
    private String companyId;
    private String companyName;
    private Date followDate;

    public MyFollowingCompanyInfo(String companyId, String companyName, Date followDate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.followDate = followDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getFollowDate() {
        return followDate;
    }


}
