package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.StudentPostEntity;
import org.hibernate.event.spi.PostDeleteEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<StudentPostEntity,Long> {
}
