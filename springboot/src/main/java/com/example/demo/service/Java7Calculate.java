package com.example.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Java7")
@Service
public class Java7Calculate implements Calculate {
    @Override
    public Integer sum(Integer... val) {
        System.out.println("==================Java7==================");
        int sum = 0;
        for (Integer integer : val) {
            sum += integer;
        }
        return sum;
    }
}
