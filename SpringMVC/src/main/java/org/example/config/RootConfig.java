package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 这个是 Root WebApplicationContext；根容器的配置。也就是Spring的
 * 如datasource、services、middle-tier
 */
@ComponentScan(basePackages = "org.example", excludeFilters = {
        // 排除所有的Controller
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class RootConfig {
}
