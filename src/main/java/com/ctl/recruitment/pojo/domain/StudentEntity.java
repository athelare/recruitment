package com.ctl.recruitment.pojo.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "student", schema = "campus_recruitment", catalog = "")
public class StudentEntity{
    private String username;
    private String studentId;
    private String password;
    private String email;
    private String schoolName;
    private String major;
    private String qqAccount;
    private String wechatAccount;
    private String portrait;
    private Timestamp regTime;
    private Byte sex;
    private String universityProvince;
    private String universityName;
    private String enrollYear;
    private String realName;
    private String identityNum;
    private String phone;
    private Byte verified;

    @Basic
    @Column(name = "student_id", length = 20)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "school_name", length = 40)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Basic
    @Column(name = "major", length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "qq_account", length = 20)
    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    @Basic
    @Column(name = "wechat_account", length = 20)
    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    @Basic
    @Column(name = "portrait", length = 100)
    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Basic
    @Column(name = "reg_time")
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(major, that.major) &&
                Objects.equals(qqAccount, that.qqAccount) &&
                Objects.equals(wechatAccount, that.wechatAccount) &&
                Objects.equals(portrait, that.portrait) &&
                Objects.equals(regTime, that.regTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, password, email, schoolName, major, qqAccount, wechatAccount, portrait, regTime);
    }

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "university_province", length = 20)
    public String getUniversityProvince() {
        return universityProvince;
    }

    public void setUniversityProvince(String universityProvince) {
        this.universityProvince = universityProvince;
    }

    @Basic
    @Column(name = "university_name", length = 40)
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Basic
    @Column(name = "enroll_year", length = 10)
    public String getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(String enroolYear) {
        this.enrollYear = enroolYear;
    }

    @Basic
    @Column(name = "real_name", length = 20)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "identity_num", length = 20)
    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    @Basic
    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "verified", nullable = false)
    public Byte getVerified() {
        return verified;
    }

    public void setVerified(Byte verified) {
        this.verified = verified;
    }
}
