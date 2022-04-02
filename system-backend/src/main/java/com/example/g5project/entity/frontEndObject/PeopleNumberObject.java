package com.example.g5project.entity.frontEndObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName PeopleNumberObject.java
 * @Description TODO
 * @createTime 2022年03月31日 12:19:00
 */
@Getter
@Setter
public class PeopleNumberObject {
    private Date date;
    private int ConsultantNumber;
    private int SupervisorNumber;

    public PeopleNumberObject(Date date, int consultantNumber, int supervisorNumber) {
        this.date = date;
        ConsultantNumber = consultantNumber;
        SupervisorNumber = supervisorNumber;
    }
}
