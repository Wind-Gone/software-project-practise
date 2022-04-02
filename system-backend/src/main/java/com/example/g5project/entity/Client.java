package com.example.g5project.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022年03月04日 09:09:00
 */
@ApiModel(value = "client")
@Entity(name = "顾客类")
public class Client {
    @Id
    private int client_id;                      /*顾客id*/
    private String name;                        /*姓名*/
    private int sex;                            /*性别，0为女，1为男*/
    private String username;                    /*用户名*/
    private String phonenumber;                 /*电话号码*/
    private String emergency_contact_name;      /*紧急联系人*/
    private String emergency_contact_phone;     /*紧急联系人电话*/
    private String identity;                    /*身份：访客*/
    private Date visit_date;                    /*访问日期*/
    private int is_diabled;                     /*是否被禁用，0：被禁用，1：未被禁用*/
}
