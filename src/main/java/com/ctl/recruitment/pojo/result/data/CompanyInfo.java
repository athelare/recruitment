package com.ctl.recruitment.pojo.result.data;

import com.ctl.recruitment.pojo.domain.CompanyEntity;

public class CompanyInfo {
    private String companyId,companyName,type,address,phone,email,logo,city,establishDate;
    public CompanyInfo(CompanyEntity c){
        this.companyId = c.getCompanyId();
        this.companyName = c.getName();
        this.type = c.getType();
        this.address = c.getAddress();
        this.phone = c.getPhone();
        this.email = c.getEmail();
        this.logo = c.getLogo();
        this.city = c.getCity();
        if(c.getStartDate() != null)
            this.establishDate = c.getStartDate().toString();
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogo() {
        return logo;
    }

    public String getCity() {
        return city;
    }

    public String getEstablishDate() {
        return establishDate;
    }
}
