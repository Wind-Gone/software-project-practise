package com.example.g5project.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName Administrator.java
 * @Description TODO
 * @createTime 2022年03月04日 09:07:00
 */
@Entity
@ApiModel(value = "管理员类")
@Table(name = "administrator")
public class Administrator {
    @Id
    @ApiModelProperty(value = "管理员id", hidden = true)
    @Column(name = "administrator_id", updatable = false)
    private int administrator_id;                   /*管理员id*/
    private String today_all_consult_time;          /*今日所有咨询师的总咨询时长*/
    private int today_all_finished_consult_time;    /*今日所有咨询师完成的咨询数量*/
    private String name;                            /*姓名*/

    @Column(name = "username", unique = true, updatable = false, length = 32)
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty
    private String username;                        /*用户名*/
    private String passward;                        /*密码*/

    public int getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getToday_all_consult_time() {
        return today_all_consult_time;
    }

    public void setToday_all_consult_time(String today_all_consult_time) {
        this.today_all_consult_time = today_all_consult_time;
    }

    public int getToday_all_finished_consult_time() {
        return today_all_finished_consult_time;
    }

    public void setToday_all_finished_consult_time(int today_all_finished_consult_time) {
        this.today_all_finished_consult_time = today_all_finished_consult_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administrator_id=" + administrator_id +
                ", today_all_consult_time='" + today_all_consult_time + '\'' +
                ", today_all_finished_consult_time=" + today_all_finished_consult_time +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", passward='" + passward + '\'' +
                '}';
    }
}
