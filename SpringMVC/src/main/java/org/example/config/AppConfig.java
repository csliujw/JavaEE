package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Spring容器不扫描 controller
// useDefaultFilters = false 禁用默认的过滤规则，默认是扫描所有的。
@ComponentScan(basePackages = "org.example", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
}, useDefaultFilters = false)
@EnableWebMvc // 开启WebMvc的配置！！！刚刚没写这个 一直404，哭了
public class AppConfig extends WebMvcConfigurerAdapter {
    // 视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 默认所有页面都从 /WEB-INF/xxx.jsp
        // registry.jsp();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 静态资源访问，静态资源，交给tomcat
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 相当于 <mvc:default-servlet-handler />
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptors());
        interceptorRegistration.addPathPatterns("/**"); // 拦截所有
    }
}

class MyInterceptors implements HandlerInterceptor {
    // 目标方法运行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    // 目标方法之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    // 页面响应后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
