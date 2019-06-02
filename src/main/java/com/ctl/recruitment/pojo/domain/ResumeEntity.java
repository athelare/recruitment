package com.ctl.recruitment.pojo.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "resume", schema = "campus_recruitment")
public class ResumeEntity {

    enum Type{ONLINE,FILE}
    private Integer resumeId;
    private Type resumeType;
    private String resumeAddress;
    private String introduce;
    private String studentUsername;
    private String portraitAddress;
    private String name;
    private Integer sex;
    private String city;
    private String phone;
    private String email;
    private String university;
    private Date eduBeginTime;
    private Date eduEndTime;
    private String eduDegree;
    private String majorName;
    private Double gpa;
    private Integer gpaRank;
    private String majorCourse;
    private String awards;
    private String internCompany;
    private String internPosition;
    private Date internStart;
    private Date internEnd;
    private String internDetail;
    private String projectName;
    private String projectRole;
    private Date projectStart;
    private Date projectEnd;
    private String projectDetail;

    @Id
    @Column(name = "resume_id", nullable = false)
    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "resume_type", nullable = true)
    public Type getResumeType() {
        return resumeType;
    }

    public void setResumeType(Type resumeType) {
        this.resumeType = resumeType;
    }

    @Basic
    @Column(name = "resume_address", nullable = true, length = 50)
    public String getResumeAddress() {
        return resumeAddress;
    }

    public void setResumeAddress(String resumeAddress) {
        this.resumeAddress = resumeAddress;
    }

    @Basic
    @Column(name = "introduce", nullable = true, length = 255)
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeEntity that = (ResumeEntity) o;
        return resumeId == that.resumeId &&
                Objects.equals(resumeType, that.resumeType) &&
                Objects.equals(resumeAddress, that.resumeAddress) &&
                Objects.equals(introduce, that.introduce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resumeId, resumeType, resumeAddress, introduce);
    }

    @Basic
    @Column(name = "student_username" ,nullable = false)
    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentId) {
        this.studentUsername = studentId;
    }

    @Basic
    @Column(name = "portrait_address", nullable = true, length = 30)
    public String getPortraitAddress() {
        return portraitAddress;
    }

    public void setPortraitAddress(String portraitAddress) {
        this.portraitAddress = portraitAddress;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 30)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "university", nullable = true, length = 30)
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Basic
    @Column(name = "edu_begin_time", nullable = true)
    public Date getEduBeginTime() {
        return eduBeginTime;
    }

    public void setEduBeginTime(Date eduBeginTime) {
        this.eduBeginTime = eduBeginTime;
    }

    @Basic
    @Column(name = "edu_end_time", nullable = true)
    public Date getEduEndTime() {
        return eduEndTime;
    }

    public void setEduEndTime(Date eduEndTime) {
        this.eduEndTime = eduEndTime;
    }

    @Basic
    @Column(name = "edu_degree", nullable = true, length = 30)
    public String getEduDegree() {
        return eduDegree;
    }

    public void setEduDegree(String eduDegree) {
        this.eduDegree = eduDegree;
    }

    @Basic
    @Column(name = "major_name", nullable = true, length = 30)
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Basic
    @Column(name = "GPA", nullable = true, precision = 0)
    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Basic
    @Column(name = "GPA_rank", nullable = true)
    public Integer getGpaRank() {
        return gpaRank;
    }

    public void setGpaRank(Integer gpaRank) {
        this.gpaRank = gpaRank;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Basic
    @Column(name = "major_course", nullable = true, length = 255)
    public String getMajorCourse() {
        return majorCourse;
    }

    public void setMajorCourse(String majorCourse) {
        this.majorCourse = majorCourse;
    }

    @Basic
    @Column(name = "awards", nullable = true, length = 255)
    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Basic
    @Column(name = "intern_company", nullable = true, length = 30)
    public String getInternCompany() {
        return internCompany;
    }

    public void setInternCompany(String internCompany) {
        this.internCompany = internCompany;
    }

    @Basic
    @Column(name = "intern_position", nullable = true, length = 30)
    public String getInternPosition() {
        return internPosition;
    }

    public void setInternPosition(String internPosition) {
        this.internPosition = internPosition;
    }

    @Basic
    @Column(name = "intern_start", nullable = true)
    public Date getInternStart() {
        return internStart;
    }

    public void setInternStart(Date internStart) {
        this.internStart = internStart;
    }

    @Basic
    @Column(name = "intern_end", nullable = true)
    public Date getInternEnd() {
        return internEnd;
    }

    public void setInternEnd(Date internEnd) {
        this.internEnd = internEnd;
    }

    @Basic
    @Column(name = "intern_detail", nullable = true, length = 255)
    public String getInternDetail() {
        return internDetail;
    }

    public void setInternDetail(String internDetail) {
        this.internDetail = internDetail;
    }

    @Basic
    @Column(name = "project_name", nullable = true, length = 30)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "project_role", nullable = true, length = 30)
    public String getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(String projectRole) {
        this.projectRole = projectRole;
    }

    @Basic
    @Column(name = "project_start", nullable = true)
    public Date getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(Date projectStart) {
        this.projectStart = projectStart;
    }

    @Basic
    @Column(name = "project_end", nullable = true)
    public Date getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(Date projectEnd) {
        this.projectEnd = projectEnd;
    }

    @Basic
    @Column(name = "project_detail", nullable = true, length = 255)
    public String getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(String projectDetail) {
        this.projectDetail = projectDetail;
    }
}
