package com.example.g5project.entity.relation;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName SupervisorSchedule.java
 * @Description TODO
 * @createTime 2022年03月04日 09:11:00
 */
@ApiModel(value = "supervisor_schedult")
@Entity(name = "督导排班类")
public class SupervisorSchedule {
    @Id
    private int supervisor_schedule_id;             /*督导排班id*/
    private int supervisor_id;                      /*督导id*/
    private int week;                               /*督导排班星期几*/
    private int month;                              /*督导排班月份*/
    private int year;                               /*督导排班年份*/
    private Date date;                              /*督导排班日期*/
}
