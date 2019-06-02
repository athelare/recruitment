package com.ctl.recruitment.pojo.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicInsert
@Table(name = "follow", schema = "campus_recruitment")
public class FollowEntity {
    private int followId;
    private CompanyEntity companyByCompanyId;
    private Timestamp followDate;

    @Id
    @Column(name = "follow_id", nullable = false)
    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowEntity that = (FollowEntity) o;
        return followId == that.followId &&
                Objects.equals(companyByCompanyId, that.companyByCompanyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followId, companyByCompanyId);
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    @Basic
    @Column(name = "follow_date", nullable = true)
    public Timestamp getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Timestamp followDate) {
        this.followDate = followDate;
    }
}
