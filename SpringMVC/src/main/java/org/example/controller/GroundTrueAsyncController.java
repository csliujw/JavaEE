package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

@Controller
public class GroundTrueAsyncController {

    @RequestMapping("/createOrder")
    @ResponseBody
    public DeferredResult<Object> createOrder() {
        // 假设我们是指定了3秒内要完成，没完成就抛出错误 create fail
        // 他需要有人设置值才算成功         deferredResult.setResult("value")
        DeferredResult<Object> deferredResult = new DeferredResult<>(10000L, "create fail");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        // 生成订单id
        String s = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        // 存入订单id
        deferredResult.setResult(s);
        return "success==>" + s;
    }
}

class DeferredResultQueue {
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedDeque<>();

    public static void save(DeferredResult<Object> deferredResult) {
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> get() {
        return queue.poll();
    }
}
