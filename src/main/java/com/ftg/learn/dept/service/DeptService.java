package com.ftg.learn.dept.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ftg.learn.dept.entity.Dept;
import com.ftg.learn.dept.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeptService extends ServiceImpl<DeptMapper, Dept> implements IService<Dept> {

    @Autowired
    DeptMapper deptMapper;

    public List<Map<String, Object>> showAll() {
        return deptMapper.show();
    }

    public int saveDept(Dept dept) {
        return deptMapper.insert(dept);
    }

    public int delDept(Integer id) {
        return deptMapper.deleteById(id);
    }

    public int updDept(Dept dept) {
        return deptMapper.updateById(dept);
    }
}
