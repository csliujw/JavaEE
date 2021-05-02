package com.example.demo.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository(value = "firstLevelRepository")
public @interface FirstLevelRepository {
    String value() default "";
}
