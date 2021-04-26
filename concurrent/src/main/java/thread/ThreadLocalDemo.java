package thread;

public class ThreadLocalDemo {
    // 测试ThreadLocal的set和get方法
    public void testThreadLocalSetAndGet() {
        // 如何模拟多线程set get ThreadLocal？  暂时只看main线程的就好
        Thread th1 = new Thread(() -> {
            ThreadLocal<String> local = new ThreadLocal<>();
            local.set("th1");
        });

        Thread th2 = new Thread(() -> {
            ThreadLocal<String> local = new ThreadLocal<>();
            local.set("th2");
        });

        Thread th3 = new Thread(() -> {
            ThreadLocal<String> local = new ThreadLocal<>();
            local.set("th3");
        });
        th1.start();
        th2.start();
        th3.start();
    }

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("123");
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        threadLocalDemo.testThreadLocalSetAndGet();
        String s = local.get();
        System.out.println(s);
    }
}
