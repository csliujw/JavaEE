package lg.controller;

public class Demo {
    int number = 10;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (long j = 0; j < 1000000000; j++) {
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 100.0);
    }
}
