package com.example.g5project.repository.repo;

import com.example.g5project.entity.Supervisor;
import com.example.g5project.entity.Supervisor;
import com.example.g5project.repository.dao.SupervisorDao;
import com.example.g5project.repository.dao.SupervisorDao;
import com.example.g5project.tools.IdService;
import org.assertj.core.util.Preconditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName SupervisorRepo.java
 * @Description TODO
 * @createTime 2022年03月23日 14:27:00
 */
@Component
@Transactional
public class SupervisorRepo extends Repo<Supervisor, Integer> {
    private final SupervisorDao supervisorDao;
    protected SupervisorRepo(JpaRepository<Supervisor, Integer> dao, SupervisorDao supervisorDao) {
        super(dao);
        this.supervisorDao = supervisorDao;
    }

    public Optional<Supervisor> findByName(String name) {
        return supervisorDao.findByName(name);
    }

    public int add(Supervisor supervisor) {
        Preconditions.checkNotNull(supervisor, "未输入内容");
        IdService idService = IdService.getInstance();
        long id = idService.getNextId();
        supervisor.setSupervisor_id((int) id);
        save(supervisor);
        return supervisor.getSupervisor_id();
    }

    public ArrayList<Supervisor> findAll() {
        return (ArrayList<Supervisor>) supervisorDao.findAll();
    }

    public int getTodayConsultNumber(int supervisor_id) {
        return supervisorDao.getByTodayConsultNumber(supervisor_id);
    }

    public String getTodayConsultTime(int supervisor_id) {
        return supervisorDao.getByTodayConsultTime(supervisor_id);
    }

    public int getAllConsultSessionNumber() {
        return supervisorDao.getAllAliveSessionNumber();
    }
}
