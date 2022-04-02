package com.example.g5project.controller;

import com.example.g5project.entity.frontEndObject.PeopleNumberObject;
import com.example.g5project.others.ResponseValue;
import com.example.g5project.service.AdministratortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName AdministratorController.java
 * @Description TODO
 * @createTime 2022年03月23日 14:25:00
 */
@Api("管理员接口操作")
@CrossOrigin
@RestController
@RequestMapping(value = "/administrator")
public class AdministratorController {
    private final AdministratortService administratortService;

    public AdministratorController(AdministratortService administratortService) {
        this.administratortService = administratortService;
    }

    @ApiOperation("根据月份返回列表")
    @RequestMapping(method = RequestMethod.GET, value = "/getInfoByMonth/{year}/{month}")
    public ResponseValue<?> getInfoByMonth(@ApiParam(value = "年份", required = true, example = "2022") @PathVariable Integer year, @ApiParam(value = "月份", required = true, example = "1") @PathVariable Integer month) {
        ArrayList<PeopleNumberObject> result = administratortService.getInfoByMonth(year, month);
        return ResponseValue.success(result);
    }

    @ApiOperation("根据日期返回咨询师名字")
    @RequestMapping(method = RequestMethod.GET, value = "/getConsultantInfoByDate/{date}")
    public ResponseValue<?> getConsultantInfoByDate(@ApiParam(value = "日期", required = true, example = "2022-02-22") @PathVariable Date date) {
        ArrayList<String> result = administratortService.getConsultantInfoByDate(date);
        return ResponseValue.success(result);
    }

    @ApiOperation("根据日期返回督导名字")
    @RequestMapping(method = RequestMethod.GET, value = "/getSupervisorInfoByDate/{date}")
    public ResponseValue<?> getSupervisorInfoByDate(@ApiParam(value = "日期", required = true, example = "2022-02-22") @PathVariable Date date) {
        ArrayList<String> result = administratortService.getSupervisorInfoByDate(date);
        return ResponseValue.success(result);
    }

    @ApiOperation("根据日期和名字添加咨询师到排班表中")
    @RequestMapping(method = RequestMethod.GET, value = "/addConsultantSchedule/{date}/{name}")
    public ResponseValue<?> addConsultantIntoScheduleByName(@ApiParam(value = "日期", required = true, example = "2022-02-22") @PathVariable Date date, @ApiParam(value = "名字", required = true, example = "czh") @PathVariable String name) {
        administratortService.addConsultantIntoScheduleByName(name, date);
        return ResponseValue.success("add consultant success");
    }

    @ApiOperation("根据日期和名字添加督导到排班表中")
    @RequestMapping(method = RequestMethod.GET, value = "/addSupervisorSchedule/{date}/{name}")
    public ResponseValue<?> addSupervisorIntoScheduleByName(@ApiParam(value = "日期", required = true, example = "2022-02-22") @PathVariable Date date, @ApiParam(value = "名字", required = true, example = "czh") @PathVariable String name) {
        administratortService.addSupervisorIntoScheduleByName(name, date);
        return ResponseValue.success("add supervisor success");
    }

    @ApiOperation("根据日期和名字删除咨询师")
    @RequestMapping(method = RequestMethod.GET, value = "/deleteConsultantSchedule/{date}/{name}")
    public ResponseValue<?> deleteConsultantFromScheduleByName(@ApiParam(value = "日期", required = true, example = "2022-02-22") @PathVariable Date date, @ApiParam(value = "名字", required = true, example = "czh") @PathVariable String name) {
        administratortService.deleteConsultantFromScheduleByName(name, date);
        return ResponseValue.success("delete consultant success");
    }

    @ApiOperation("根据日期和名字删除督导")
    @RequestMapping(method = RequestMethod.GET, value = "/deleteSupervisorSchedule/{date}/{name}")
    public ResponseValue<?> deleteSupervisorFromScheduleByName(@ApiParam(value = "日期", required = true, example = "2022-02-22") @PathVariable Date date, @ApiParam(value = "名字", required = true, example = "czh") @PathVariable String name) {
        administratortService.deleteSupervisorFromScheduleByName(name, date);
        return ResponseValue.success("delete supervisor success");
    }

}
