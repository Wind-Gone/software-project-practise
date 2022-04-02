package com.example.g5project.repository.dao;

import com.example.g5project.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName AdministratorDao.java
 * @Description TODO
 * @createTime 2022年03月25日 14:28:00
 */
@Repository
@Transactional
@SuppressWarnings("all")
public interface AdministratorDao extends JpaRepository<Administrator, Integer>, JpaSpecificationExecutor {
    @Query(value = "select count (*) from consultant_schedule where schedule_date = ?1", nativeQuery = true)
    int getConsultantNumber(Date date);

    @Query(value = "select count (*) from supervisor_schedule where schedule_date = ?1", nativeQuery = true)
    int getSupervisorNumber(Date date);

    @Query(value = "select consultant.name from consultant_schedule,consultant where schedule_date = ?1 and consultant.consultant_id = consultant_schedule.consultant_id", nativeQuery = true)
    ArrayList<String> getConsultantName(Date date);

    @Query(value = "select supervisor.name from supervisor_schedule,consultant where schedule_date = ?1 and supervisor.supervisor_id = supervisor_schedule.supervisor_id", nativeQuery = true)
    ArrayList<String> getSupervisorName(Date date);

    @Query(value = "insert into consultant_schedule (consultant_id, date) values (?1, ?2)", nativeQuery = true)
    void addConsultantSchedule(int id, Date date);

    @Query(value = "insert into supervisor_schedule (supervisor_id, date) values (?1, ?2)", nativeQuery = true)
    void addSupervisorSchedule(int id, Date date);

    @Query(value = "delete from consultant_schedule where consultant_id = ?1 and schedule_date = ?2", nativeQuery = true)
    void deleteConsultantSchedule(int id, Date date);

    @Query(value = "delete from supervisor_schedule where supervisor_id = ?1 and schedule_date = ?2", nativeQuery = true)
    void deleteSupervisorSchedule(int id, Date date);

    @Query(value = "select consultant_id from consultant where name = ?1", nativeQuery = true)
    int getConsultantID(String name);

    @Query(value = "select supervisor_id from supervisor where name = ?1", nativeQuery = true)
    int getSupervisorID(String name);

    @Query(value = "insert into consultant_supervisor (consultant_id, supervisor_id) values (?1,?2)", nativeQuery = true)
    void bind(int consultant_id, int supervisor_id);
}
