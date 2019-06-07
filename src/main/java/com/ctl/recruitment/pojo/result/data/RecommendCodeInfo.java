package com.ctl.recruitment.pojo.result.data;

public class RecommendCodeInfo {


    public RecommendCodeInfo(String companyId, String website, String username, String recommendCode) {
        this.companyId = companyId;
        this.website = website;
        this.username = username;
        this.recommendCode = recommendCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    private String companyId;
    private String website;
    private String username;
    private String recommendCode;
}
