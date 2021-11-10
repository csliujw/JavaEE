package com.miaosha.bootconcurrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

/**
 * 计数累加。
 * curl 做测试，调用 2w次 200QPS  ，对数字进行累加
 */

@RestController
@RequestMapping("/local")
public class ThreadLocalController {
    /**
     * ThreadLocal 实现多线程并发计数
     * 如何做累加呢？
     * 自定义一个 val 类，local 对val类的变量做累加。最后对所有的 val 类做累加
     */
    int number = 0;
    static HashSet<Val<Integer>> set = new HashSet<>();
    static ThreadLocal<Val<Integer>> local = new ThreadLocal() {
        @Override
        protected Val<Integer> initialValue() {
            Val<Integer> val = new Val<>();
            val.val = 0;
            set.add(val);
            return val;
        }
    };

    static class Val<T> {
        T val;
    }

    @GetMapping("/count")
    public void count() {
        Val<Integer> val = local.get();
        val.val++;
        local.set(val);
    }

    @GetMapping("/get")
    public int get() {
        return set.stream().map(e -> e.val).mapToInt(e -> e).sum();
    }
}
