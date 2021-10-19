package com.ftg.learn.dept.controller;

import com.ftg.learn.dept.entity.Dept;
import com.ftg.learn.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/show")
    public Object tes(){
        return deptService.listMaps();
    }

    @PostMapping("/save")
    //post
    public int insert(Dept dept){
        return deptService.saveDept(dept);
    }

    @DeleteMapping("/del")
    //post
    public int delete(@RequestParam Integer id){
        return deptService.delDept(id);
    }

    @PostMapping("/upd")
    //post
    public int upd(Dept dept){
        return deptService.updDept(dept);
    }

}
