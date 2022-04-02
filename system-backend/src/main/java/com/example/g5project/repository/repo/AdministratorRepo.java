package com.example.g5project.repository.repo;

import com.example.g5project.entity.Administrator;
import com.example.g5project.repository.dao.AdministratorDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName AdministratorRepo.java
 * @Description TODO
 * @createTime 2022年03月23日 14:26:00
 */
@Component
@Transactional
public class AdministratorRepo extends Repo<Administrator, Integer> {
    private final AdministratorDao administratorDao;

    protected AdministratorRepo(JpaRepository<Administrator, Integer> dao, AdministratorDao administratorDao) {
        super(dao);
        this.administratorDao = administratorDao;
    }

    public int getCurrentDateConsultantNumber(Date date) {
        return administratorDao.getConsultantNumber(date);
    }

    public int getCurrentDateSupervisorNumber(Date date) {
        return administratorDao.getSupervisorNumber(date);
    }

    public ArrayList<String> getConsultantInfoByDate(Date date) {
        return administratorDao.getConsultantName(date);
    }

    public ArrayList<String> getSupervisorInfoByDate(Date date) {
        return administratorDao.getSupervisorName(date);
    }

    public void addConsultantIntoScheduleByID(int id, Date date) {
        administratorDao.addConsultantSchedule(id, date);
    }

    public void addSupervisorIntoScheduleByID(int id, Date date) {
        administratorDao.addSupervisorSchedule(id, date);
    }

    public void deleteConsultantFromScheduleByID(int id, Date date) {
        administratorDao.deleteConsultantSchedule(id, date);
    }

    public void deleteSupervisorFromScheduleByID(int id, Date date) {
        administratorDao.deleteSupervisorSchedule(id, date);
    }

    public int getConsultantIDByName(String name) {
        return administratorDao.getConsultantID(name);
    }

    public int getSupervisorIDByName(String name) {
        return administratorDao.getSupervisorID(name);
    }

    public void bindConsultantAndSupervisor(int consultant_id, int supervisor_id) {
        administratorDao.bind(consultant_id, supervisor_id);
    }
}
