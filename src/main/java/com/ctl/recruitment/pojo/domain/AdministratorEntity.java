package com.ctl.recruitment.pojo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "administrator", schema = "campus_recruitment", catalog = "")
public class AdministratorEntity {
    private String adminUsername;
    private String password;

    @Id
    @Column(name = "admin_username", nullable = false, length = 30)
    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministratorEntity that = (AdministratorEntity) o;
        return Objects.equals(adminUsername, that.adminUsername) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminUsername, password);
    }
}
