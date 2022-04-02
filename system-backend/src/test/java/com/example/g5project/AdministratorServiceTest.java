package com.example.g5project;

import com.example.g5project.service.AdministratortService;
import com.example.g5project.service.ConsultantService;
import com.example.g5project.service.SupervisorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName AdministratorServiceTest.java
 * @Description TODO
 * @createTime 2022年04月01日 11:29:00
 */
@SpringBootTest
public class AdministratorServiceTest {
    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private AdministratortService administratortService;
    @Autowired
    private SupervisorService supervisorService;

    @Test
    public void testAll() {
        System.out.println(administratortService.getInfoByMonth(2022,1));
//        System.out.println(administratortService.getConsultantInfoByDate(""));
    }
}
