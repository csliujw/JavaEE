package com.example.demo.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Java系统属性判断
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    // java系统属性名
    String name();

    // java系统属性值
    String value();
}
