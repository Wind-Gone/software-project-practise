package com.example.g5project.entity.relation;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantSchedule.java
 * @Description TODO
 * @createTime 2022年03月04日 09:11:00
 */

@ApiModel(value = "consultant_schedult")
@Entity(name = "咨询师排班类")
@Getter
@Setter
public class ConsultantSchedule {
    @Id
    private int consultant_schedule_id;        /*咨询师排班id*/
    private int consultant_id;                 /*咨询师id*/
    private int week;                          /*咨询排班星期几*/
    private int month;                         /*咨询排班月份*/
    private int year;                          /*咨询排班年份*/
    private Date date;                         /*咨询排班日期*/
}
