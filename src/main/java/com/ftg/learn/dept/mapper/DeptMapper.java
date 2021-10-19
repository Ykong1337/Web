package com.ftg.learn.dept.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ftg.learn.dept.entity.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends BaseMapper<Dept> {

    @Select("select * from dept left join emp on dept.deptno = emp.deptno")
    List<Map<String, Object>> show();

}
