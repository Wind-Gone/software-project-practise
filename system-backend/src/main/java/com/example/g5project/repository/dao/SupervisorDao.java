package com.example.g5project.repository.dao;

import com.example.g5project.entity.Supervisor;
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
 * @ClassName SupervisorDao.java
 * @Description TODO
 * @createTime 2022年03月23日 14:28:00
 */
@Repository
@Transactional
@SuppressWarnings("all")
public interface SupervisorDao extends JpaRepository<Supervisor, Integer>, JpaSpecificationExecutor {
    @Query(value = "select * from Supervisor where name  = ?1", nativeQuery = true)
    Optional<Supervisor> findByName(String name);

    @Query(value = "select today_finished_consult from Supervisor where supervisor_id = ?1", nativeQuery = true)
    int getByTodayConsultNumber(int Supervisor_id);

    @Query(value = "select today_consult_time from Supervisor where supervisor_id = ?1", nativeQuery = true)
    String getByTodayConsultTime(int Supervisor_id);

    @Query(value = "select * from supervisor where is_alive = 1", nativeQuery = true)
    ArrayList<Supervisor> getAllAliveSupervisor();

    @Query(value = "select sum(alive_session_number) from supervisor", nativeQuery = true)
    int getAllAliveSessionNumber();

    @Query(value = "select supervisor_client.Supervisor_id, count(*) from supervisor_client,supervisor where MONTH(consult_date) = ?2 and supervisor.supervisor_id\n" +
            "= supervisor_client.Supervisor_id group by supervisor_client.Supervisor_id order by count(*) desc limit ?1 ;", nativeQuery = true)
    ArrayList<Supervisor> getSupervisorByConsultNumber(int k, int month);

    @Query(value = "select supervisor_client.supervisor_id, sum(consult_grade) as g from supervisor_client,supervisor where MONTH(consult_date) = ?2 and supervisor.supervisor_id\n" +
            "= supervisor_client.Supervisor_id group by supervisor_client.supervisor_id order by g desc limit ?1 ;", nativeQuery = true)
    ArrayList<Supervisor> getSupervisorByGrade(int k, int month);
}
