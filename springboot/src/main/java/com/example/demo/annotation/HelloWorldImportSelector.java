package com.example.demo.annotation;

import com.example.demo.config.HelloWorldConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld {@link org.springframework.context.annotation.ImportSelector} 实现
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[]{"com.example.demo.config.HelloWorldConfig"};
        //getName 类全名
        return new String[]{HelloWorldConfig.class.getName()};

    }
}
