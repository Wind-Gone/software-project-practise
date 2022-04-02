package com.example.g5project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName Consultant.java
 * @Description TODO
 * @createTime 2022年03月04日 09:07:00
 */
@ApiModel(value = "consultant")
@Entity(name = "consultant")
public class Consultant {
    @Id
    @JsonProperty(value = "consultant_id")
    private int consultant_id;              /*咨询师ID*/
    @JsonProperty(value = "alive_session_number")
    private int alive_session_number;       /*当前正在咨询的会话数量*/
    @JsonProperty(value = "today_consult_time")
    private String today_consult_time;      /*今日咨询时长*/
    @JsonProperty(value = "today_finished_consult")
    private int today_finished_consult;     /*今日完成的咨询数量*/
    @JsonProperty(value = "evaluation_grade")
    private int evaluation_grade;           /*综合评价打分，1-5颗星*/
    @JsonProperty(value = "all_finished_consult")
    private int all_finished_consult;       /*累计完成的咨询数量*/
    @JsonProperty(value = "all_finished_time")
    private int all_finished_time;          /*累计完成的咨询时长*/
    @JsonProperty(value = "is_alive")
    private int is_alive;                   /*是否在线（0：不在，1：在线）*/
    @JsonProperty(value = "is_free")
    private int is_free;                    /*是否空闲（0：不空闲，1：空闲）*/
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

    public Consultant() {
    }

    public void setConsultant_id(int consultant_id) {
        this.consultant_id = consultant_id;
    }

    public int getToday_finished_consult() {
        return today_finished_consult;
    }

    public void setToday_finished_consult(int today_finished_consult) {
        this.today_finished_consult = today_finished_consult;
    }

    public Consultant(int consultant_id, int alive_session_number, String today_consult_time, int today_finished_consult, int evaluation_grade, int all_finished_consult, int all_finished_time, int is_alive, int is_free, String name, int sex, int age, String ID_card, String phonenumber, String email, String username, String workuint, String title) {
        this.consultant_id = consultant_id;
        this.alive_session_number = alive_session_number;
        this.today_consult_time = today_consult_time;
        this.today_finished_consult = today_finished_consult;
        this.evaluation_grade = evaluation_grade;
        this.all_finished_consult = all_finished_consult;
        this.all_finished_time = all_finished_time;
        this.is_alive = is_alive;
        this.is_free = is_free;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.ID_card = ID_card;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
        this.workuint = workuint;
        this.title = title;
    }

    public int getConsultant_id() {
        return consultant_id;
    }

    public void setConsultant_id(Integer consultant_id) {
        this.consultant_id = consultant_id;
    }

    public int getAlive_session_number() {
        return alive_session_number;
    }

    public void setAlive_session_number(int alive_session_number) {
        this.alive_session_number = alive_session_number;
    }

    public String getToday_consult_time() {
        return today_consult_time;
    }

    public void setToday_consult_time(String today_consult_time) {
        this.today_consult_time = today_consult_time;
    }

    public int getEvaluation_grade() {
        return evaluation_grade;
    }

    public void setEvaluation_grade(int evaluation_grade) {
        this.evaluation_grade = evaluation_grade;
    }

    public int getAll_finished_consult() {
        return all_finished_consult;
    }

    public void setAll_finished_consult(int all_finished_consult) {
        this.all_finished_consult = all_finished_consult;
    }

    public int getAll_finished_time() {
        return all_finished_time;
    }

    public void setAll_finished_time(int all_finished_time) {
        this.all_finished_time = all_finished_time;
    }

    public int getIs_alive() {
        return is_alive;
    }

    public void setIs_alive(int is_alive) {
        this.is_alive = is_alive;
    }

    public int getIs_free() {
        return is_free;
    }

    public void setIs_free(int is_free) {
        this.is_free = is_free;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getID_card() {
        return ID_card;
    }

    public void setID_card(String ID_card) {
        this.ID_card = ID_card;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWorkuint() {
        return workuint;
    }

    public void setWorkuint(String workuint) {
        this.workuint = workuint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
