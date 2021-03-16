package org.example.config;

import org.example.MyStringToPersonConverter;
import org.example.interceptor.MyInterceptor;
import org.example.view.MyViewResolver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
}, useDefaultFilters = false)
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 视图解析器
     *
     * @param registry
     */
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 注册一个视图解析器
        registry.viewResolver(new MyViewResolver());
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // DefaultServletHandling 不拦截静态资源
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        MyStringToPersonConverter myStringToPersonConverter = new MyStringToPersonConverter();
        registry.addConverter(myStringToPersonConverter);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/");
    }

}
