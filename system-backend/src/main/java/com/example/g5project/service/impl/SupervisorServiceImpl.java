package com.example.g5project.service.impl;

import com.example.g5project.entity.Supervisor;
import com.example.g5project.exception.EntityNotExistException;
import com.example.g5project.repository.repo.SupervisorRepo;
import com.example.g5project.service.SupervisorService;
import org.assertj.core.util.Preconditions;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName SupervisorServiceImpl.java
 * @Description TODO
 * @createTime 2022年03月09日 13:18:00
 */
@Service
@Transactional
public class SupervisorServiceImpl implements SupervisorService {
    private final SupervisorRepo supervisorRepo;

    public SupervisorServiceImpl(SupervisorRepo supervisorRepo) {
        this.supervisorRepo = supervisorRepo;
    }

    @Override
    public Supervisor getSupervisorByID(Integer id) throws EntityNotExistException {
        Preconditions.checkNotNull(id, "未输入督导ID");
        Optional<Supervisor> opt = supervisorRepo.findById(id);
        if (opt.isPresent())
            return opt.get();
        throw new EntityNotExistException("Supervisor");
    }

    @Override
    public Supervisor getCounsultantByName(String name) throws EntityNotExistException {
        Preconditions.checkNotNull(name, "未输入督导姓名");
        Optional<Supervisor> opt = supervisorRepo.findByName(name);
        if (opt.isPresent())
            return opt.get();
        throw new EntityNotExistException("Supervisor");
    }

    @Override
    public Integer addSupervisor(Supervisor Supervisor) {
        Preconditions.checkNotNull(Supervisor, "未输入督导信息");
        return supervisorRepo.add(Supervisor);
    }

    @Override
    public void deleteSupervisorByID(Integer id) {
        Preconditions.checkNotNull(id, "未输入督导ID");
        supervisorRepo.deleteById(id);
    }

    @Override
    public void updateSupervisorByID(Integer id, Supervisor Supervisor) throws EntityNotExistException {
        Preconditions.checkNotNull(Supervisor, "未输入督导信息");
        Preconditions.checkNotNull(id, "未输入督导ID");
        supervisorRepo.updateById(id, Supervisor);
    }

    @Override
    public ArrayList<Supervisor> getAllSupervisor() {
        return supervisorRepo.findAll();
    }

    @Override
    public int getTodayConsultNumber(int id) {
        Preconditions.checkNotNull(id, "未输入督导ID");
        return supervisorRepo.getTodayConsultNumber(id);
    }

    @Override
    public String getTodayConsultTime(int id) {
        Preconditions.checkNotNull(id, "未输入督导ID");
        return supervisorRepo.getTodayConsultTime(id);
    }

    @Override
    public int getAllConsultSessionNumber() {
        return supervisorRepo.getAllConsultSessionNumber();
    }


}