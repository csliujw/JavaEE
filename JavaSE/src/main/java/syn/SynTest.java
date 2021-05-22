package syn;

import java.util.concurrent.TimeUnit;

/**
 * 因为sync是可重入锁。同一个线程可以多次获取同一把锁。
 */
public class SynTest {
    static volatile int i = 0;

    public void add() {
        synchronized (this) {
            i++;
            System.out.println("i+了");
        }
    }

    public void reduce() {
        i--;
        System.out.println("i--了");
        add();
    }

    public void test() {
        synchronized (this) {
            reduce();
        }
    }

    public static void main(String[] args) {
        SynTest synTest = new SynTest();
        synTest.test();
    }
}
