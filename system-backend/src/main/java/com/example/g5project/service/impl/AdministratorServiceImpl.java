package com.example.g5project.service.impl;

import com.example.g5project.entity.frontEndObject.PeopleNumberObject;
import com.example.g5project.repository.repo.AdministratorRepo;
import com.example.g5project.service.AdministratortService;
import org.assertj.core.util.Preconditions;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantServiceImpl.java
 * @Description TODO
 * @createTime 2022年03月09日 13:18:00
 */
@Service
@Transactional
public class AdministratorServiceImpl implements AdministratortService {
    private final AdministratorRepo administratorRepo;


    public AdministratorServiceImpl(AdministratorRepo administratorRepo) {
        this.administratorRepo = administratorRepo;
    }

    @Override
    public ArrayList<PeopleNumberObject> getInfoByMonth(int year, int month) {
        Preconditions.checkNotNull(year, "月份不能为空");
        Preconditions.checkArgument(month >= 1 && month <= 12, "月份不合理");
        ArrayList<PeopleNumberObject> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int maxDate = calendar.get(Calendar.DATE);
        String dateStr = "";
        Date date = new Date();
        for (int i = 1; i < maxDate; i++) {
            if (i < 10)
                dateStr = year + "-" + month + "-0" + i;
            else
                dateStr = year + "-" + month + "-" + i;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            PeopleNumberObject peopleNumberObject = new PeopleNumberObject(date, administratorRepo.getCurrentDateConsultantNumber(date), administratorRepo.getCurrentDateSupervisorNumber(date));
            result.add(peopleNumberObject);
        }
        return result;
    }

    @Override
    public ArrayList<String> getConsultantInfoByDate(Date date) {
        Preconditions.checkNotNull(date, "日期不能为空");
        return administratorRepo.getConsultantInfoByDate(date);
    }

    @Override
    public ArrayList<String> getSupervisorInfoByDate(Date date) {
        Preconditions.checkNotNull(date, "日期不能为空");
        return administratorRepo.getSupervisorInfoByDate(date);
    }

    @Override
    public void addConsultantIntoScheduleByName(String name, Date date) {
        Preconditions.checkNotNull(date, "日期不能为空");
        Preconditions.checkNotNull(name, "姓名不能为空");
        int id = administratorRepo.getConsultantIDByName(name);
        administratorRepo.addConsultantIntoScheduleByID(id, date);
    }

    @Override
    public void addSupervisorIntoScheduleByName(String name, Date date) {
        Preconditions.checkNotNull(date, "日期不能为空");
        Preconditions.checkNotNull(name, "姓名不能为空");
        int id = administratorRepo.getSupervisorIDByName(name);
        administratorRepo.addSupervisorIntoScheduleByID(id, date);
    }

    @Override
    public void deleteConsultantFromScheduleByName(String name, Date date) {
        Preconditions.checkNotNull(date, "日期不能为空");
        Preconditions.checkNotNull(name, "姓名不能为空");
        int id = administratorRepo.getConsultantIDByName(name);
        administratorRepo.deleteConsultantFromScheduleByID(id, date);
    }

    @Override
    public void deleteSupervisorFromScheduleByName(String name, Date date) {
        Preconditions.checkNotNull(date, "日期不能为空");
        Preconditions.checkNotNull(name, "姓名不能为空");
        int id = administratorRepo.getConsultantIDByName(name);
        administratorRepo.deleteSupervisorFromScheduleByID(id, date);
    }

    @Override
    public void bindConsultantAndSupervisor(int consultant_id, int supervisor_id) {
        Preconditions.checkNotNull(consultant_id, "咨询师id不能为空");
        Preconditions.checkNotNull(supervisor_id, "督导id不能为空");
        administratorRepo.bindConsultantAndSupervisor(consultant_id, supervisor_id);
    }
}
