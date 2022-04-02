package com.example.g5project.repository.dao;

import com.example.g5project.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantDao.java
 * @Description TODO
 * @createTime 2022年03月25日 15:08:00
 */
@Repository
@Transactional
@SuppressWarnings("all")
public interface ConsultantDao extends JpaRepository<Consultant, Integer>, JpaSpecificationExecutor {
    @Query(value = "select * from consultant where name  = ?1", nativeQuery = true)
    Optional<Consultant> findByName(String name);

    @Query(value = "select today_finished_consult from consultant where consultant_id = ?1", nativeQuery = true)
    int getByTodayConsultNumber(int consultant_id);

    @Query(value = "select today_consult_time from consultant where consultant_id = ?1", nativeQuery = true)
    String getByTodayConsultTime(int consultant_id);

    @Query(value = "select * from consultant where is_alive = 1", nativeQuery = true)
    ArrayList<Consultant> getAllAliveConsultant();

    @Query(value = "select sum(alive_session_number) from consultant", nativeQuery = true)
    int getAllAliveSessionNumber();

    @Query(value = "select consultant_client.consultant_id, count(*) from consultant_client,consultant where MONTH(consult_date) = ?2 and consultant.consultant_id\n" +
            "= consultant_client.consultant_id group by consultant_client.consultant_id order by count(*) desc limit ?1 ;", nativeQuery = true)
    ArrayList<Consultant> getConsultantByConsultNumber(int k, int month);

    @Query(value = "select consultant_client.consultant_id, sum(consult_grade) as g from consultant_client,consultant where MONTH(consult_date) = ?2 and consultant.consultant_id\n" +
            "= consultant_client.consultant_id group by consultant_client.consultant_id order by g desc limit ?1 ;", nativeQuery = true)
    ArrayList<Consultant> getConsultantByGrade(int k, int month);



}

