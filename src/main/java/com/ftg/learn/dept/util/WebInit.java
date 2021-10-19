package com.ftg.learn.dept.util;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //初始化注解web上下文配置
        System.out.println("---> AnnotationConfigWebApplicationContext - web.xml webapp");
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan("com.ftg.learn.dept");
        //加载web.xml里面的spring监听程序
        servletContext.addListener(new ContextLoaderListener(root));

        //初始化控制器
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        //将springmvc配置文件类添加到web.xml里面的配置上
        dispatcherServlet.register(SpringmvcConfig.class);

        //注册控制器为 为一个servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
                new DispatcherServlet(dispatcherServlet));
        //初始化配置文件里面的servlet加载顺序
        dispatcher.setLoadOnStartup(1);
        //初始化配置文件启动路径
        dispatcher.addMapping("/");
    }
}
