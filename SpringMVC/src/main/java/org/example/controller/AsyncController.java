package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Controller
public class AsyncController {

    @ResponseBody
    @RequestMapping("/async")
    /**
     * 1、控制器返回Callable
     * 2、Spring异步处理，将Callable 提交道TaskExecutor 使用一个隔离的线程进行执行。
     * 3、DispatcherServlet和所有的Filter退出web容器的线程，但是response 保持打开状态。
     * 4、Callable返回结果，SpringMVC将重新发送请求。
     * 5、根据Callable返回的结果。SpringMVC继续进行视图渲染流程等。（从收请求 -> 视图渲染）
     *
     * 控制台输出 验证了上述的说法
     * preHandle
     * 主线程开始是...http-nio-8080-exec-2 ==> 1611740780382
     * 主线程结束是...http-nio-8080-exec-2 ==> 1611740780382
     * ===============DispatcherServlet及所有的Filter退出线程===============
     *
     * ===============等待Callable执行完成===============
     * 副线程是...MvcAsync1 ==> 1611740780394
     * 副线程是...MvcAsync1 ==> 1611740782395
     *
     * ===============Callable执行完成后又发送了一次请求===============
     * preHandle
     * postHandle
     * afterCompletion
     *
     *
     * -----------------------------
     * 异步请求拦截器：
     *      - 原生api：AsyncListener
     *      - SpringMVC；实现AsyncHandlerInterceptor
     */
    public Callable<String> async() {
        System.out.println(String.format("主线程开始是...%s ==> %s", Thread.currentThread().getName(), System.currentTimeMillis()));
        Callable<String> callable = () -> {
            System.out.println(String.format("副线程是...%s ==> %s", Thread.currentThread().getName(), System.currentTimeMillis()));
            TimeUnit.SECONDS.sleep(2);
            System.out.println(String.format("副线程是...%s ==> %s", Thread.currentThread().getName(), System.currentTimeMillis()));
            return "Callable<String> async";
        };
        System.out.println(String.format("主线程结束是...%s ==> %s", Thread.currentThread().getName(), System.currentTimeMillis()));
        return callable;
    }
}
