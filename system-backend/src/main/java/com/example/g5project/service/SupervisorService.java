package com.example.g5project.service;

import com.example.g5project.entity.Supervisor;
import com.example.g5project.exception.EntityNotExistException;

import java.util.ArrayList;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName SupervisorService.java
 * @Description TODO
 * @createTime 2022年03月23日 13:18:00
 */

public interface SupervisorService {
    Supervisor getSupervisorByID(Integer id) throws EntityNotExistException;                                            // 根据ID获取督导信息

    Supervisor getCounsultantByName(String name) throws EntityNotExistException;                                        // 根据姓名获取督导信息

    Integer addSupervisor(Supervisor Supervisor);                                                                       // 增加一个新的督导

    void deleteSupervisorByID(Integer id);                                                                              // 根据ID删除一个督导

    void updateSupervisorByID(Integer id, Supervisor Supervisor) throws EntityNotExistException;                        // 根据ID更新Supervisor内容

    ArrayList<Supervisor> getAllSupervisor() throws EntityNotExistException;                                            // 查询所有督导

    int getTodayConsultNumber(int Supervisor_id);                                                                       // 返回今日咨询数

    String getTodayConsultTime(int Supervisor_id);                                                                      // 返回今日咨询时长

    int getAllConsultSessionNumber();                                                                                   // 返回督导会话数量


}
