package com.example.g5project.service;

import com.example.g5project.entity.Consultant;
import com.example.g5project.entity.relation.ConsultantClient;
import com.example.g5project.exception.EntityNotExistException;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantService.java
 * @Description TODO
 * @createTime 2022年03月09日 13:18:00
 */
public interface ConsultantService {
    Consultant getConsultantByID(Integer id) throws EntityNotExistException;                                            // 根据ID获取咨询师信息

    Consultant getCounsultantByName(String name) throws EntityNotExistException;                                        // 根据姓名获取咨询师信息

    Integer addConsultant(Consultant consultant);                                                                       // 增加一个新的咨询师

    void deleteConsultantByID(Integer id);                                                                              // 根据ID删除一个咨询师

    void updateConsultantByID(Integer id, Consultant consultant) throws EntityNotExistException;                        // 根据ID更新consultant内容

    ArrayList<Consultant> getAllConsultant() throws EntityNotExistException;                                            // 查询所有咨询师

    int getTodayConsultNumber(int consultant_id);                                                                       // 返回今日咨询数

    String getTodayConsultTime(int consultant_id);                                                                      // 返回今日咨询时长

    ArrayList<Consultant> getAllAliveConsultant() throws EntityNotExistException;                                       // 返回所有在线的咨询师

    int getAllConsultSessionNumber();                                                                                   // 返回咨询师会话数量

    ArrayList<Consultant> getFirstKrankConsultantByConsultNumber(int k, int month) throws EntityNotExistException;      // 返回前k个咨询数量排行最高的咨询师

    ArrayList<Consultant> getFirstKrankConsultantByMonthsGrade(int k, int month) throws EntityNotExistException;        // 返回前k个月好评最高的咨询师



}
