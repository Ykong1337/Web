package com.ftg.learn.dept.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    @TableId
    public int deptno;

    public String dname;

    public String loc;
}
