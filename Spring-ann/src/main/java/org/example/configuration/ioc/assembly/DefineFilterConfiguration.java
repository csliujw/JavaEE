package org.example.configuration.ioc.assembly;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "org.example", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {DefineFilter.class})
}, useDefaultFilters = false)
public class DefineFilterConfiguration {
}

class DefineFilter implements TypeFilter {
    // 自定义匹配规则
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获得当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获得当前类资源（类路径）
        Resource resource = metadataReader.getResource();
        // 类名
        String className = classMetadata.getClassName();
        System.out.println("---->" + className);
        if (className.contains("Dao")) {
            return true;
        }
        return false;
    }
}