package lg.controller;

import java.util.HashMap;

public class Demo {
    int number = 10;

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", "1");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (long j = 0; j < 1000000000; j++) {
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 100.0);
    }
}
