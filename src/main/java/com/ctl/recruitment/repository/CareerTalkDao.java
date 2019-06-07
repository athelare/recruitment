package com.ctl.recruitment.repository;

import com.ctl.recruitment.pojo.domain.CareerTalkEntity;
import com.ctl.recruitment.pojo.domain.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CareerTalkDao extends JpaRepository<CareerTalkEntity,Long> {
    /*学生寻找自己关注的公司的宣讲会*/
    @Query(value = "SELECT career_talk.* FROM career_talk INNER JOIN follow ON career_talk.company_id = follow.company_id AND follow.student_username = :username",nativeQuery = true)
    List<CareerTalkEntity> findByUsername(String username);


    /*公司查找自己的宣讲会*/
    /*查找全部宣讲会*/
    @Query(value = "SELECT * FROM career_talk WHERE company_id = :companyId LIMIT :bg,:pg",nativeQuery = true)
    List<CareerTalkEntity>findAllByCompany(String companyId,Integer bg,Integer pg);

    @Query(value = "SELECT COUNT(*) FROM career_talk WHERE company_id = :companyId",nativeQuery = true)
    Integer countAllByCompany(String companyId);





    /*查看还没有举办的宣讲会*/
    @Query(value = "SELECT * FROM career_talk WHERE company_id = :companyId AND held_time > current_timestamp LIMIT :bg,:pg",nativeQuery = true)
    List<CareerTalkEntity>findPendingByCompany(String companyId,Integer bg,Integer pg);

    @Query(value = "SELECT COUNT(*) FROM career_talk WHERE company_id = :companyId AND held_time > current_timestamp",nativeQuery = true)
    Integer countPendingByCompany(String companyId);









    /*查看已经成功举办的宣讲会*/
    @Query(value = "SELECT * FROM career_talk WHERE company_id = :companyId AND held_time < current_timestamp LIMIT :bg,:pg",nativeQuery = true)
    List<CareerTalkEntity>findFinishedByCompany(String companyId,Integer bg,Integer pg);

    @Query(value = "SELECT COUNT(*) FROM career_talk WHERE company_id = :companyId AND held_time < current_timestamp",nativeQuery = true)
    Integer countFinishedByCompany(String companyId);
}
