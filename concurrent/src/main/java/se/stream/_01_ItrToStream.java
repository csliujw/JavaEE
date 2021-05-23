package se.stream;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 从迭代到Stream <br>
 * 1. 流遵循做什么而非怎么做 <br>
 * 2. 流不存储元素，这些元素可能存储在底层的集合中，或者按需生产。 <br>
 * 3. 流的操作不会修改其数据源。 <br>
 * -----
 * 操作流的典型流程：<br>
 * 1. 创建一个流 <br>
 * 2. 将初始流转为其他流 <br>
 * 3.  应用终止操作 <br>
 * -----
 * api：<br>
 * Stream<T> filter() 产生一个流，满足条件 <br>
 * long count() 产生当前流中元素的数量，是一个终止操作 <br>
 * words.stream() 产生当前集合中所有元素的顺序流 <br>
 * words.parallelStream() 产生当前集合中所有元素的并行流 <br>
 * ----
 * 可以用集合.stream()产生一个流。<br>
 * 可以Stream.of(T...) 将多个元素或数组变为流<br>
 * ----
 * 创建无限流 <br>
 * Stream.generate(()->"asf") 产生一个无限常量流 <br>
 * Stream.generate(Math::random) 无限随机数流 <br>
 * ----
 * 序列迭代 <br>
 * Stream.iterate
 * ----
 * filter、map、flatMap <br>
 */
public class _01_ItrToStream {

    public void stream() throws IOException {
        Path path = Paths.get("D:\\Code\\JavaEE\\concurrent\\src\\main\\resources\\_01_ItrToStream.txt");
        String msg = new String(Files.readAllBytes(path));
        List<String> words = List.of(msg.split(" "));
        long count = words.stream().filter(w -> w.length() > 5).count();
        System.out.println(count);
    }

    public void parallelStream() throws IOException {
        Path path = Paths.get("D:\\Code\\JavaEE\\concurrent\\src\\main\\resources\\_01_ItrToStream.txt");
        String msg = new String(Files.readAllBytes(path));
        List<String> words = List.of(msg.split(" "));
        long count = words.parallelStream().filter(w -> w.length() > 3).count();
        System.out.println(count);
    }

    public void createStream() {
        Stream<Integer> integerStream = Stream.of(1, 1, 1, 1, 1, 4, 5, 6, 7, 5, 6, 5, 7);
        System.out.println(integerStream.filter(element -> element > 4).count());
    }

    public void infinite() {
        Stream<String> constant = Stream.generate(() -> "123");
        // 遍历无限流
        constant.forEach(System.out::println);
        System.out.println("======================");
        Stream<Double> random = Stream.generate(Math::random);
        random.forEach(System.out::println);
    }

    public void iterate() {
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1);
        iterate.forEach(System.out::println);
    }


    public void map() {
        Stream<Integer> stream = Stream.of(1, 1, 1, 1, 1, 4, 5, 6, 7, 5, 6, 5, 7);
        Stream<Integer> stream1 = stream.map(e -> e + e);
        stream1.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        _01_ItrToStream obj = new _01_ItrToStream();
        obj.map();
    }

}
