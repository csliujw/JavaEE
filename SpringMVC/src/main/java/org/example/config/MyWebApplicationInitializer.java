package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Web容器启动的时候创建对象；调用方法来初始化容器前端控制器
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 获取根容器的配置类; （以前是利用Spring的配置文件的方式，创建出一个父容器）
    protected Class<?>[] getRootConfigClasses() {

        return new Class[]{RootConfig.class};
    }

    // 获取web容器的配置类，相当于SpringMVC配置文件。
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // 获取DispatcherServlet的映射信息
    protected String[] getServletMappings() {
        // /    拦截所有资源，包括静态文件，但是不包括*.jsp
        // /*    拦截所有资源，包括静态文件和*.jsp；jsp页面是tomcat的jsp引擎解析的。
        return new String[]{"/"};
    }
}
