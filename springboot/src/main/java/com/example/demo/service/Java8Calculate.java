package com.example.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Profile("Java8")
@Service
public class Java8Calculate implements Calculate {
    @Override
    public Integer sum(Integer... val) {
        System.out.println("==================Java8==================");
        return Stream.of(val).reduce(0, Integer::sum);
    }
}
