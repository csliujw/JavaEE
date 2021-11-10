package com.miaosha.bootconcurrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.LongAdder;

@RestController
@RequestMapping("/adder")
public class LongAdderController {

    static LongAdder sum = new LongAdder();

    @GetMapping("/count")
    public void count() {
        sum.increment();
    }

    @GetMapping("/get")
    public long get() {
        return sum.sum();
    }
}
