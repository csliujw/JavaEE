package com.example.demo.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository(value = "secondLevelRepository")
public @interface SecondLevelRepository {
}
