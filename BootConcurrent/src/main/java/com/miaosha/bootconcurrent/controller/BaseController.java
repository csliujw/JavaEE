package com.miaosha.bootconcurrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {
    /**
     * 加锁版本，基础累加
     */
    int number = 0;

    @GetMapping("/count")
    public void count() {
        synchronized (this) {
            number++;
        }
    }

    @GetMapping("/get")
    public int get() {
        return number;
    }
}
