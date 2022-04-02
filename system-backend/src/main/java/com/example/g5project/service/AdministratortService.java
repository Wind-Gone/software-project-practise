package com.example.g5project.service;

import com.example.g5project.entity.frontEndObject.PeopleNumberObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantService.java
 * @Description TODO
 * @createTime 2022年03月23日 13:18:00
 */
public interface AdministratortService {

    ArrayList<PeopleNumberObject> getInfoByMonth(int year, int month);                                                  // 给定月份，返回日期、咨询师数量、督导数量

    ArrayList<String> getConsultantInfoByDate(Date date);                                                               // 给定日期，返回咨询师列表

    ArrayList<String> getSupervisorInfoByDate(Date date);                                                               // 给定日期，返回督导列表

    void addConsultantIntoScheduleByName(String name, Date date);                                                       // 根据姓名添加一个咨询师到排班表中

    void addSupervisorIntoScheduleByName(String name, Date date);                                                       // 根据姓名添加一个督导到排班表中

    void deleteConsultantFromScheduleByName(String name, Date date);                                                    // 根据姓名从排班表中删除咨询师

    void deleteSupervisorFromScheduleByName(String name, Date date);                                                    // 根据姓名从排班表中删除督导

    void bindConsultantAndSupervisor(int consultant_id, int supervisor_id);                                             // 根据id绑定督导和咨询师
}
