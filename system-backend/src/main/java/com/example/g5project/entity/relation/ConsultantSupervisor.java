package com.example.g5project.entity.relation;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantSupervisor.java
 * @Description TODO
 * @createTime 2022年03月04日 09:11:00
 */

@ApiModel(value = "consultant_supervisor")
@Entity(name = "咨询师督导绑定关系类")
public class ConsultantSupervisor {
    @Id
    private int consultant_supervisor_id;       /*督导咨询师绑定关系id*/
    private int consultant_id;                  /*咨询师id*/
    private int supervisor_id;                  /*督导id*/
}
