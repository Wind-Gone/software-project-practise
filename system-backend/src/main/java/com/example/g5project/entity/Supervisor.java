package com.example.g5project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName Supervisor.java
 * @Description TODO
 * @createTime 2022年03月04日 09:09:00
 */
@ApiModel(value = "supervisor")
@Entity(name = "督导类")
@Getter
@Setter
public class Supervisor {
    @Id
    @JsonProperty(value = "supervisor_id")
    private int supervisor_id;              /*督导ID*/
    @JsonProperty(value = "today_consult_time")
    private String today_consult_time;      /*今日咨询时长*/
    @JsonProperty(value = "today_finished_consult")
    private int today_finished_consult;     /*今日完成的咨询数量*/
    @JsonProperty(value = "all_finished_consult")
    private int all_finished_consult;       /*总督导数量*/
    @JsonProperty(value = "all_finished_time")
    private String all_finished_time;       /*总督导时长*/
    @JsonProperty(value = "name")
    private String name;                    /*姓名*/
    @JsonProperty(value = "sex")
    private int sex;                        /*性别，0为女，1为男*/
    @JsonProperty(value = "age")
    private int age;                        /*年龄*/
    @JsonProperty(value = "ID_card")
    private String ID_card;                 /*身份证号码*/
    @JsonProperty(value = "phonenumber")
    private String phonenumber;             /*电话号码*/
    @JsonProperty(value = "email")
    private String email;                   /*邮箱*/
    @JsonProperty(value = "username")
    private String username;                /*用户名*/
    @JsonProperty(value = "workuint")
    private String workuint;                /*工作单位*/
    @JsonProperty(value = "title")
    private String title;                   /*职称*/
    @JsonProperty(value = "certificate")
    private String certificate;             /*资质*/
    @JsonProperty(value = "certification_number")
    private String certification_number;    /*资质编号*/
}
