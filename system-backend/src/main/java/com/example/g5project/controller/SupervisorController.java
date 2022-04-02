package com.example.g5project.controller;

import com.example.g5project.entity.Supervisor;
import com.example.g5project.exception.EntityNotExistException;
import com.example.g5project.others.ResponseValue;
import com.example.g5project.service.SupervisorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName SupervisorController.java
 * @Description TODO
 * @createTime 2022年03月23日 14:25:00
 */
@Api("督导接口操作")
@CrossOrigin
@RestController
@RequestMapping(value = "/supervisor")
public class SupervisorController {
    private final SupervisorService supervisorService;

    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @ApiOperation("获取所有督导会话数量")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllSessionNumber")
    public ResponseValue<?> getAllConsultSessionNumber() {
        int count = supervisorService.getAllConsultSessionNumber();
        return ResponseValue.success(count);
    }

    @ApiOperation("根据ID获取督导信息")
    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public ResponseValue<?> getSupervisorByID(@ApiParam(value = "需要获取信息的督导ID", required = true, example = "-947912704") @PathVariable Integer id) throws EntityNotExistException {
        Supervisor supervisor = supervisorService.getSupervisorByID(id);
        return ResponseValue.success(supervisor);
    }

    @ApiOperation("根据姓名获取督导信息")
    @RequestMapping(method = RequestMethod.GET, value = "/get/{name}")
    public ResponseValue<?> getSupervisorByName(@ApiParam(value = "需要获取信息的督导姓名", required = true, example = "czh") @PathVariable String name) throws EntityNotExistException {
        Supervisor supervisor = supervisorService.getCounsultantByName(name);
        return ResponseValue.success(supervisor);
    }

    @ApiOperation("获取所有督导信息")
    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseValue<?> getAllSupervisor() throws EntityNotExistException {
        ArrayList<Supervisor> SupervisorArrayList = supervisorService.getAllSupervisor();
        return ResponseValue.success(SupervisorArrayList);
    }

    @ApiOperation("根据ID硬删除督导")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseValue<?> deleteSupervisorByID(@ApiParam(value = "需要获取信息的督导ID", required = true, example = "1") @PathVariable Integer id) {
        supervisorService.deleteSupervisorByID(id);
        return ResponseValue.success("success delete");
    }

    @ApiOperation("根据ID和新的信息，更新督导，现在可以传入一个不完整的Supervisor类型了")
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseValue<?> updateSupervisorByID(@ApiParam(value = "需要获取信息的督导ID", required = true, example = "2") @PathVariable Integer id, @RequestBody @Validated Supervisor supervisor) throws EntityNotExistException {
        supervisor.setSupervisor_id(id);
        supervisorService.updateSupervisorByID(id, supervisor);
        return ResponseValue.success("success update");
    }

    @ApiOperation("根据ID和新的信息，新增督导")
    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public ResponseValue<?> addSupervisor(@ApiParam(value = "新增的督导", required = true) @RequestBody @Validated Supervisor supervisor) {
        supervisorService.addSupervisor(supervisor);
        return ResponseValue.success("success add");
    }

    @ApiOperation("根据ID获取督导今日咨询数")
    @RequestMapping(method = RequestMethod.GET, value = "/getTodayConsultNumber/{id}")
    public ResponseValue<?> getTodayConsultNumber(@ApiParam(value = "需要获取信息的督导ID", required = true, example = "-947912704") @PathVariable Integer id) {
        int count = supervisorService.getTodayConsultNumber(id);
        return ResponseValue.success(count);
    }

    @ApiOperation("根据ID获取督导今日咨询时长")
    @RequestMapping(method = RequestMethod.GET, value = "/getTodayConsultTime/{id}")
    public ResponseValue<?> getTodayConsultTime(@ApiParam(value = "需要获取信息的督导ID", required = true, example = "-947912704") @PathVariable Integer id) {
        String count = supervisorService.getTodayConsultTime(id);
        return ResponseValue.success(count);
    }

}
