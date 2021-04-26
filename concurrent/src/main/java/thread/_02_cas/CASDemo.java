package thread._02_cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5, 10);
        atomicInteger.getAndIncrement();
        /**
         *     this：当前对象
         *     VALUE：内存偏移量，也就是内存地址
         *     1 加一
         *     public final int getAndIncrement() {
         *         return U.getAndAddInt(this, VALUE, 1);
         *     }
         */
        System.out.println(atomicInteger.get());
    }
}
