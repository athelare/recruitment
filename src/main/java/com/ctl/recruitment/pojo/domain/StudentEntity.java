package com.ctl.recruitment.pojo.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "campus_recruitment")
public class StudentEntity {
    private String studentId;
    private String password;
    private String email;
    private String schoolName;
    private String major;
    private String qqAccount;
    private String wechatAccount;
    private String portrait;
    private Timestamp regTime;

    @Id
    @Column(name = "student_id", nullable = false, length = 20)
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
    @Column(name = "email", nullable = true, length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "school_name", nullable = true, length = 40)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Basic
    @Column(name = "major", nullable = true, length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "qq_account", nullable = true, length = 20)
    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    @Basic
    @Column(name = "wechat_account", nullable = true, length = 20)
    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    @Basic
    @Column(name = "portrait", nullable = true, length = 20)
    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Basic
    @Column(name = "reg_time", nullable = true)
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
}
