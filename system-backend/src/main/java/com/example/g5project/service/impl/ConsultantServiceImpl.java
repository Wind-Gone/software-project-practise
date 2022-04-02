package com.example.g5project.service.impl;

import com.example.g5project.entity.Consultant;
import com.example.g5project.exception.EntityNotExistException;
import com.example.g5project.repository.repo.ConsultantRepo;
import com.example.g5project.service.ConsultantService;
import org.assertj.core.util.Preconditions;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantServiceImpl.java
 * @Description TODO
 * @createTime 2022年03月09日 13:18:00
 */
@Service
@Transactional
public class ConsultantServiceImpl implements ConsultantService {
    private final ConsultantRepo consultantRepo;

    public ConsultantServiceImpl(ConsultantRepo consultantRepo) {
        this.consultantRepo = consultantRepo;
    }

    @Override
    public Consultant getConsultantByID(Integer id) throws EntityNotExistException {
        Preconditions.checkNotNull(id, "未输入咨询师ID");
        Optional<Consultant> opt = consultantRepo.findById(id);
        if (opt.isPresent())
            return opt.get();
        throw new EntityNotExistException("Consultant");
    }

    @Override
    public Consultant getCounsultantByName(String name) throws EntityNotExistException {
        Preconditions.checkNotNull(name, "未输入咨询师姓名");
        Optional<Consultant> opt = consultantRepo.findByName(name);
        if (opt.isPresent())
            return opt.get();
        throw new EntityNotExistException("Consultant");
    }

    @Override
    public Integer addConsultant(Consultant consultant) {
        Preconditions.checkNotNull(consultant, "未输入咨询师信息");
        return consultantRepo.add(consultant);
    }

    @Override
    public void deleteConsultantByID(Integer id) {
        Preconditions.checkNotNull(id, "未输入咨询师ID");
        consultantRepo.deleteById(id);
    }

    @Override
    public void updateConsultantByID(Integer id, Consultant consultant) throws EntityNotExistException {
        Preconditions.checkNotNull(consultant, "未输入咨询师信息");
        Preconditions.checkNotNull(id, "未输入咨询师ID");
        consultantRepo.updateById(id, consultant);
    }

    @Override
    public ArrayList<Consultant> getAllConsultant() {
        return consultantRepo.findAll();
    }

    @Override
    public int getTodayConsultNumber(int id) {
        Preconditions.checkNotNull(id, "未输入咨询师ID");
        return consultantRepo.getTodayConsultNumber(id);
    }

    @Override
    public String getTodayConsultTime(int id) {
        Preconditions.checkNotNull(id, "未输入咨询师ID");
        return consultantRepo.getTodayConsultTime(id);
    }

    @Override
    public ArrayList<Consultant> getAllAliveConsultant() {
        return consultantRepo.getAllAliveConsultant();
    }

    @Override
    public int getAllConsultSessionNumber() {
        return consultantRepo.getAllConsultSessionNumber();
    }

    @Override
    public ArrayList<Consultant> getFirstKrankConsultantByConsultNumber(int k, int month) throws EntityNotExistException {
        Preconditions.checkArgument(k > 0, "应该至少返回大于0的数量");
        Preconditions.checkArgument(month >= 1 && month <= 12, "月份不合理");
        return consultantRepo.getFirstKrankConsultantByConsultNumber(k, month);
    }

    @Override
    public ArrayList<Consultant> getFirstKrankConsultantByMonthsGrade(int k, int month) throws EntityNotExistException {
        Preconditions.checkArgument(k > 0, "应该至少返回大于0的数量");
        Preconditions.checkArgument(month >= 1 && month <= 12, "月份不合理");
        return consultantRepo.getFirstKrankConsultantByMonthsGrade(k, month);
    }


}
