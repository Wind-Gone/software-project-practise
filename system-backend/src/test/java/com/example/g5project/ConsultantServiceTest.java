package com.example.g5project;

import com.example.g5project.controller.ConsultantController;
import com.example.g5project.entity.Consultant;
import com.example.g5project.exception.EntityNotExistException;
import com.example.g5project.service.ConsultantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantServiceTest.java
 * @Description TODO
 * @createTime 2022年03月25日 15:32:00
 */
@SpringBootTest
public class ConsultantServiceTest {
    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private ConsultantController consultantController;

    @Test
    public void testSelectById(int id) throws EntityNotExistException {
        id = 2080374784;
        System.out.println(consultantService.getConsultantByID(id));
    }

    @Test
    public void addNewConsultant() {
        Consultant consultant = new Consultant();
        consultant.setConsultant_id(2);
        consultant.setAlive_session_number(1);
        consultant.setToday_consult_time("1");
        consultant.setEvaluation_grade(1);
        consultant.setAll_finished_consult(1);
        consultant.setAll_finished_time(1);
        consultant.setIs_alive(1);
        consultant.setIs_free(1);
        consultant.setName("czh");
        consultant.setSex(1);
        consultant.setAge(18);
        consultant.setID_card("1111");
        consultant.setPhonenumber("11");
        consultant.setEmail("111");
        consultant.setUsername("nan");
        consultant.setWorkuint("ecnu");
        consultant.setTitle("stu");
        System.out.println(consultantService.addConsultant(consultant));
    }

    @Test
    public void testSelectAll() throws EntityNotExistException {
        System.out.println(consultantService.getAllConsultant());
    }


    @Test
    public void testDeleteById() throws EntityNotExistException {
        System.out.println(consultantService.getAllConsultant().size());
        consultantService.deleteConsultantByID(-12582912);
        System.out.println(consultantService.getAllConsultant().size());
    }

    @Test
    public void testUpdateById() throws EntityNotExistException {
        int id = -947912704;
        Consultant consultant = new Consultant();
        consultant.setConsultant_id(-947912704);
        consultant.setAlive_session_number(1);
        consultant.setToday_consult_time("1");
        consultant.setEvaluation_grade(1);
        consultant.setAll_finished_consult(1);
        consultant.setAll_finished_time(1);
        consultant.setIs_alive(1);
        consultant.setIs_free(1);
        consultant.setName("ptt");
        consultant.setSex(1);
        consultant.setAge(18);
        consultant.setID_card("1111");
        consultant.setPhonenumber("11");
        consultant.setEmail("111");
        consultant.setUsername("nan");
        consultant.setWorkuint("ecnu");
        consultant.setTitle("stu");
        Consultant consultant1 = consultantService.getConsultantByID(id);
        System.out.println(consultant1.getName());
        consultantService.updateConsultantByID(id, consultant);
        Consultant consultant2 = consultantService.getConsultantByID(id);
        System.out.println(consultant2.getName());
        assert !consultant2.getName().equals(consultant1.getName());
    }

    @Test
    public void testController() throws EntityNotExistException {
        System.out.println(consultantController.getConsultantByID(-12582912).getPayload());
    }

}
