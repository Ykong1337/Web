package com.ftg.learn.dept.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ftg.learn.dept.entity.Dept;
import com.ftg.learn.dept.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeptService extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    public List<Map<String,Object>> showAll(){
        return deptMapper.show();
    }

}
