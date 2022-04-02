package com.example.g5project.entity.relation;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantClient.java
 * @Description TODO
 * @createTime 2022年03月04日 09:12:00
 */
@ApiModel(value = "consultant_client")
@Entity(name = "咨询师和咨询者的咨询记录表")
public class ConsultantClient {
    @Id
    private int consult_record_id;      /*咨询记录id*/
    private int consultant_id;          /*咨询师id*/
    private int client_id;              /*顾客id*/
    private String consult_time;        /*咨询时长*/
    private Date consult_date;          /*咨询日期*/
    private int consult_grade;          /*咨询打分评级，1-5分*/
    private String consult_comment;     /*咨询评价内容*/
    private int consult_message_id;     /*咨询聊天内容id*/
}
