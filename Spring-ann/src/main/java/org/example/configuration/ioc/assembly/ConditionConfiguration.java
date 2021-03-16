package org.example.configuration.ioc.assembly;

import org.example.pojo.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

class LinuxCondition implements Condition {

    /**
     * @param context  判断能使用的上下文环境
     * @param metadata 当前标注了Condtion注解的标注信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        if (property != null && property.contains("linux"))
            return true;
        return false;
    }
}

class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        if (property != null && property.contains("Window"))
            return true;
        return false;
    }
}

/**
 * 包含某个bean才xxx
 */
class ConditionDemo implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        context.getBeanFactory();
        context.getClassLoader();
        context.getEnvironment();
        BeanDefinitionRegistry registry = context.getRegistry();
        boolean windows = registry.containsBeanDefinition("windows");
        if (windows)
            return true;
        return false;
        // bean的注冊还未学习
    }
}


@Configuration
public class ConditionConfiguration {

    @Bean("linux")
    @Conditional(value = {LinuxCondition.class})
    public Person getLinux() {
        return new Person("linux");
    }

    @Bean("windows")
    @Conditional(value = {WindowsCondition.class})
    public Person getWindows() {
        return new Person("windows");
    }

    // 包含指定的Bean才注入此obj对象
    @Bean("obj")
    @Conditional(value = {ConditionDemo.class})
    public Object getObj() {
        return new Object();
    }
}
