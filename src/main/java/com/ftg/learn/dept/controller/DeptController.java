package com.ftg.learn.dept.controller;

import com.ftg.learn.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/first")
    public String test(){
        return "hello";
    }


    @GetMapping("/select")
    public Object test1(){
        return deptService.showAll();
    }


}
