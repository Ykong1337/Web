package com.ftg.learn.dept.testdept;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ftg.learn.dept.entity.Dept;
import com.ftg.learn.dept.mapper.DeptMapper;
import com.ftg.learn.dept.util.Myconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeptMapperTest {

    DeptMapper deptMapper;

    @BeforeTest
    public void init(){
        AnnotationConfigApplicationContext bf1 = new AnnotationConfigApplicationContext(Myconfig.class);
        deptMapper = bf1.getBean(DeptMapper.class);
    }

    @Test
    public void testDeptMapper(){
        //生成where 条件
        QueryWrapper<Dept> qw = new QueryWrapper<>();
        qw.like("dname","S");
        qw.orderByAsc("deptno");
        deptMapper.selectList(qw).forEach(System.out::println);
    }
}
