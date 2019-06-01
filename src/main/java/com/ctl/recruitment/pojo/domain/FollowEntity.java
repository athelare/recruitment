package com.ctl.recruitment.pojo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "follow", schema = "campus_recruitment")
public class FollowEntity {
    static enum FollowStatus{FOLLOW,CANCELED}
    private int followId;
    private FollowStatus status;
    private CompanyEntity companyByCompanyId;

    @Id
    @Column(name = "follow_id", nullable = false)
    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public FollowStatus getStatus() {
        return status;
    }

    public void setStatus(FollowStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowEntity that = (FollowEntity) o;
        return followId == that.followId &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followId, status);
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
