package com.ftg.learn.dept.util;




import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.ftg.learn.dept.mapper")
public class MyConfig {

    @Bean
    public DataSource initDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("ykong");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        return driverManagerDataSource;
    }

    /**
     * 实现化mybatis plus 分页功能
     * @return
     */
    @Bean
    public PaginationInterceptor initMybatisPage(){
        PaginationInterceptor pi = new PaginationInterceptor();
        pi.setDbType(DbType.MYSQL);
        return pi;
    }

    /**
     * 我想把spring 配置文件 里面对于mybatis整合的配置提取到java类里面
     * @configuration 完成配置功能
     * @bean 把当前方法返回 时注入ioc容器里面
     * @return
     */
    @Bean
    public MybatisSqlSessionFactoryBean initMybatisSqlSessionFactoryBean(){
        MybatisSqlSessionFactoryBean msf = new MybatisSqlSessionFactoryBean();
        msf.setDataSource(this.initDataSource());
        msf.setPlugins(this.initMybatisPage());
        return msf;
    }

    @Bean
    public AutowiredAnnotationBeanPostProcessor abc(){
        return new AutowiredAnnotationBeanPostProcessor();
    }

}
