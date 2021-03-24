package thread;


import org.apache.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * tasklist | findstr .java
 */
public class CreateThread {

    private static Logger log = Logger.getLogger(CreateThread.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test5();
    }

    // 直接使用Thread。线程和任务都写在了一块
    public static void test1() {
        Thread th1 = new Thread(() -> {
            log.debug("线程 启动了~~");
        }, "test1");
        th1.start();
    }

    // 使用runnable。Runnable里书写任务。Thread进行线程调用。线程和任务分开了。
    public static void test2() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("test2");
            }
        };
        Thread th1 = new Thread(runnable);
        th1.start();
    }

    public static void test3() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("test3");
            }
        };
        Thread th1 = new Thread(runnable, "th1");
        th1.start();
    }

    // lambda简化写法
    public static void test4() {
        Runnable run = () -> {
            log.debug("lambda");
        };
        Thread lambda = new Thread(run, "lambda");
        lambda.start();
    }

    //FutureTask 配合 Thread
    public static void test5() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            log.debug("futureTask is running");
            TimeUnit.SECONDS.sleep(5);
            return 100;
        });
        new Thread(futureTask, "futureTask").start();
        // get阻塞住，等待结果的到来。
        log.debug("结果是" + futureTask.get());
    }
}
