package com.ctl.recruitment.pojo.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "recommend_code", schema = "campus_recruitment")
public class RecommendCodeEntity {
    private Integer recommendId;
    private String recommendCode;
    private String studentUsername;
    private CompanyEntity companyByCompanyId;

    @Id
    @Column(name = "recommend_id", nullable = false)
    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    @Basic
    @Column(name = "recommend_code", nullable = false, length = 40)
    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }

    @Basic
    @Column(name = "student_username", nullable = false, length = 255)
    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendCodeEntity that = (RecommendCodeEntity) o;
        return Objects.equals(recommendId, that.recommendId) &&
                Objects.equals(recommendCode, that.recommendCode) &&
                Objects.equals(studentUsername, that.studentUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recommendId, recommendCode, studentUsername);
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }
}
