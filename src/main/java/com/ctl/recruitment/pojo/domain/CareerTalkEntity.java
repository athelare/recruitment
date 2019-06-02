package com.ctl.recruitment.pojo.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "career_talk", schema = "campus_recruitment")
public class CareerTalkEntity {
    private int careerTalkId;
    private String place;
    private Timestamp heldTime;
    private CompanyEntity company;

    @Id
    @Column(name = "career_talk_id", nullable = false)
    public int getCareerTalkId() {
        return careerTalkId;
    }

    public void setCareerTalkId(int careerTalkId) {
        this.careerTalkId = careerTalkId;
    }

    @Basic
    @Column(name = "place", nullable = false, length = 30)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "held_time", nullable = false)
    public Timestamp getHeldTime() {
        return heldTime;
    }

    public void setHeldTime(Timestamp heldTime) {
        this.heldTime = heldTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerTalkEntity that = (CareerTalkEntity) o;
        return careerTalkId == that.careerTalkId &&
                Objects.equals(place, that.place) &&
                Objects.equals(heldTime, that.heldTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(careerTalkId, place, heldTime);
    }

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "company_id", nullable = false)
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity companyId) {
        this.company = companyId;
    }
}
