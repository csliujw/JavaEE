package data_structure;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 有界阻塞队列。这个界好像是Integer.MAX_VALUE 0x7fffffff
 */
public class ArrayBlockingQueueSource {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        queue.put("1");
        queue.take();

    }
}
