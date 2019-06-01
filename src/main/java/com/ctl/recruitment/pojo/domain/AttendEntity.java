package com.ctl.recruitment.pojo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "attend", schema = "campus_recruitment")
public class AttendEntity {
    private int attendId;

    @Id
    @Column(name = "attend_id", nullable = false)
    public int getAttendId() {
        return attendId;
    }

    public void setAttendId(int attendId) {
        this.attendId = attendId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendEntity that = (AttendEntity) o;
        return attendId == that.attendId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendId);
    }
}
