package com.example.g5project.repository.repo;

import com.example.g5project.entity.Consultant;
import com.example.g5project.repository.dao.ConsultantDao;
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
 * @ClassName ConsultantRepo.java
 * @Description TODO
 * @createTime 2022年03月25日 14:50:00
 */
@Component
@Transactional
public class ConsultantRepo extends Repo<Consultant, Integer> {
    private final ConsultantDao consultantDao;

    public ConsultantRepo(JpaRepository<Consultant, Integer> dao, ConsultantDao consultantDao) {
        super(dao);
        this.consultantDao = consultantDao;
    }

    public Optional<Consultant> findByName(String name) {
        return consultantDao.findByName(name);
    }

    public int add(Consultant consultant) {
        Preconditions.checkNotNull(consultant, "未输入内容");
        IdService idService = IdService.getInstance();
        long id = idService.getNextId();
        consultant.setConsultant_id((int) id);
        save(consultant);
        return consultant.getConsultant_id();
    }

    public ArrayList<Consultant> findAll() {
        return (ArrayList<Consultant>) consultantDao.findAll();
    }

    public int getTodayConsultNumber(int consultant_id) {
        return consultantDao.getByTodayConsultNumber(consultant_id);
    }

    public String getTodayConsultTime(int consultant_id) {
        return consultantDao.getByTodayConsultTime(consultant_id);
    }

    public ArrayList<Consultant> getAllAliveConsultant() {
        return consultantDao.getAllAliveConsultant();
    }

    public int getAllConsultSessionNumber() {
        return consultantDao.getAllAliveSessionNumber();
    }

    public ArrayList<Consultant> getFirstKrankConsultantByConsultNumber(int k, int month) {
        return consultantDao.getConsultantByConsultNumber(k, month);
    }

    public ArrayList<Consultant> getFirstKrankConsultantByMonthsGrade(int k, int month) {
        return consultantDao.getConsultantByGrade(k, month);
    }
}
