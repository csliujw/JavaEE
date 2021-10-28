package com.miaosha.bootconcurrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 计数累加。
 * curl 做测试，调用 2w次 200QPS  ，对数字进行累加
 */

@RestController
public class SaleController {
}
