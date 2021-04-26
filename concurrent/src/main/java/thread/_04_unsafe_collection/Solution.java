package thread._04_unsafe_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList线程不安全怎么办？用Vector或者Collections.synchronized()
 */
public class Solution {
    public static void solutionTest1() throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread[] pool = new Thread[30];

        // 初始化好线程
        for (int i = 0; i < 30; i++) {
            Thread th = new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    list.add(1);
                }
            });
            pool[i] = th;
        }
        // 开启线程
        for (int i = 0; i < pool.length; i++) {
            pool[i].start();
        }

        while (Thread.activeCount() > 2)
            Thread.yield();
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);
    }

    public static void solutionTest2() throws InterruptedException {
        Vector<Integer> list = new Vector<>();
        Thread[] pool = new Thread[30];
        // 初始化好线程
        for (int i = 0; i < 30; i++) {
            Thread th = new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    list.add(1);
                }
            });
            pool[i] = th;
        }
        // 开启线程
        for (int i = 0; i < pool.length; i++) {
            pool[i].start();
        }

        while (Thread.activeCount() > 2)
            Thread.yield();
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);
    }

    public static void solutionTest3() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    }

    public static void main(String[] args) throws InterruptedException {
        solutionTest2();
    }
}
