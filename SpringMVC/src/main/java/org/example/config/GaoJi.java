package org.example.config;

import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class GaoJi extends WebMvcConfigurerAdapter {
    // 视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 默认所有页面都从 /WEB-INF/xxx.jsp
        // registry.jsp();
        registry.jsp("/WEB-INF/views/", "jsp");
    }
}
