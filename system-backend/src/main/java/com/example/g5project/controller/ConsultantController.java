package com.example.g5project.controller;

import com.example.g5project.entity.Consultant;
import com.example.g5project.exception.EntityNotExistException;
import com.example.g5project.others.ResponseValue;
import com.example.g5project.service.ConsultantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantController.java
 * @Description TODO
 * @createTime 2022年03月23日 15:33:00
 */
@Api("咨询师接口操作")
@CrossOrigin
@RestController
@RequestMapping(value = "/consultant")
public class ConsultantController {
    private final ConsultantService consultantService;

    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @ApiOperation("根据ID获取咨询师信息")
    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public ResponseValue<?> getConsultantByID(@ApiParam(value = "需要获取信息的咨询师ID", required = true, example = "-947912704") @PathVariable Integer id) throws EntityNotExistException {
        Consultant consultant = consultantService.getConsultantByID(id);
        return ResponseValue.success(consultant);
    }

    @ApiOperation("根据姓名获取咨询师信息")
    @RequestMapping(method = RequestMethod.GET, value = "/get/{name}")
    public ResponseValue<?> getConsultantByName(@ApiParam(value = "需要获取信息的咨询师姓名", required = true, example = "czh") @PathVariable String name) throws EntityNotExistException {
        Consultant consultant = consultantService.getCounsultantByName(name);
        return ResponseValue.success(consultant);
    }

    @ApiOperation("获取所有咨询师信息")
    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseValue<?> getAllConsultant() throws EntityNotExistException {
        ArrayList<Consultant> consultantArrayList = consultantService.getAllConsultant();
        return ResponseValue.success(consultantArrayList);
    }

    @ApiOperation("根据ID硬删除咨询师")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseValue<?> deleteConsultantByID(@ApiParam(value = "需要获取信息的咨询师ID", required = true, example = "-947912704") @PathVariable Integer id) {
        consultantService.deleteConsultantByID(id);
        return ResponseValue.success("success delete");
    }

    @ApiOperation("根据ID和新的信息，更新咨询师，现在可以传入一个不完整的Consultant类型了")
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseValue<?> updateConsultantByID(@ApiParam(value = "需要获取信息的咨询师ID", required = true, example = "-947912704") @PathVariable Integer id, @RequestBody @Validated Consultant consultant) throws EntityNotExistException {
        consultant.setConsultant_id(id);
        consultantService.updateConsultantByID(id, consultant);
        return ResponseValue.success("success update");
    }

    @ApiOperation("根据ID和新的信息，新增咨询师")
    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public ResponseValue<?> addConsultant(@ApiParam(value = "新增的咨询师", required = true) @RequestBody @Validated Consultant consultant) {
        consultantService.addConsultant(consultant);
        return ResponseValue.success("success add");
    }

    @ApiOperation("根据ID获取咨询师今日咨询数")
    @RequestMapping(method = RequestMethod.GET, value = "/getTodayConsultNumber/{id}")
    public ResponseValue<?> getTodayConsultNumber(@ApiParam(value = "需要获取信息的咨询师ID", required = true, example = "-947912704") @PathVariable Integer id) throws EntityNotExistException {
        int count = consultantService.getTodayConsultNumber(id);
        return ResponseValue.success(count);
    }

    @ApiOperation("根据ID获取咨询师今日咨询时长")
    @RequestMapping(method = RequestMethod.GET, value = "/getTodayConsultTime/{id}")
    public ResponseValue<?> getTodayConsultTime(@ApiParam(value = "需要获取信息的咨询师ID", required = true, example = "-947912704") @PathVariable Integer id) throws EntityNotExistException {
        String count = consultantService.getTodayConsultTime(id);
        return ResponseValue.success(count);
    }

    @ApiOperation("获取所有在线咨询师")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllAlive")
    public ResponseValue<?> getAllAliveConsultant() throws EntityNotExistException {
        ArrayList<Consultant> consultantArrayList = consultantService.getAllAliveConsultant();
        return ResponseValue.success(consultantArrayList);
    }


    @ApiOperation("获取所有咨询师会话数量")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllSessionNumber")
    public ResponseValue<?> getAllConsultSessionNumber() {
        int count = consultantService.getAllConsultSessionNumber();
        return ResponseValue.success(count);
    }

    @ApiOperation("根据当月咨询数量获取前k个咨询师")
    @RequestMapping(method = RequestMethod.GET, value = "/getTopKByConsultNumber/{k}/{month}")
    public ResponseValue<?> getFirstKrankConsultantByConsultNumber(@ApiParam(value = "需要的数量", required = true, example = "3") @PathVariable Integer k, @ApiParam(value = "月份", required = true, example = "1") @PathVariable Integer month) throws EntityNotExistException {
        ArrayList<Consultant> consultantArrayList = consultantService.getFirstKrankConsultantByConsultNumber(k, month);
        return ResponseValue.success(consultantArrayList);
    }

    @ApiOperation("根据当月好评数量获取前k个咨询师")
    @RequestMapping(method = RequestMethod.GET, value = "/getTopKByGrade/{k}/{month}")
    public ResponseValue<?> getFirstKrankConsultantByMonthsGrade(@ApiParam(value = "需要的数量", required = true, example = "3") @PathVariable Integer k, @ApiParam(value = "月份", required = true, example = "1") @PathVariable Integer month) throws EntityNotExistException {
        ArrayList<Consultant> consultantArrayList = consultantService.getFirstKrankConsultantByMonthsGrade(k, month);
        return ResponseValue.success(consultantArrayList);
    }

}
