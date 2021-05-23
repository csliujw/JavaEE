package se.io;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * 以Stream流的方式读取文本内容
 */
public class ReadText {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ReadText.class.getResourceAsStream("/data1.txt")));
        Stream<String> lines = bufferedReader.lines();
        lines.forEach(System.out::println);
    }
}
