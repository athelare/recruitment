package com.ctl.recruitment.pojo.result.data;

public class StudentInfo {
    private String username;
    private String realName;
    private String universityName;
    private String phone;
    private String email;
    private String portrait;

    public StudentInfo(String username, String realName, String universityName, String phone, String email, String portrait) {
        this.username = username;
        this.realName = realName;
        this.universityName = universityName;
        this.phone = phone;
        this.email = email;
        this.portrait = portrait;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPortrait() {
        return portrait;
    }
}
