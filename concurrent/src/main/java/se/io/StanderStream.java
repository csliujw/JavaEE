package se.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 标准的输入流。从控制台读入数据。
 */
public class StanderStream {
    public void test1() throws IOException {
        InputStream stream = System.in;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
        byte[] bytes = new byte[1024];
        int read = bufferedInputStream.read(bytes);
        System.out.println(new String(bytes, 0, read));
    }

    // 输出流
    // 直接打印到文本中。
    public void test2() {
        // public PrintWriter(String fileName, String csn) csn 支持的字符编码
//        URL resource = StanderStream.class.getResource("/standerStream.txt");
//        System.out.println(resource.getPath());

        try {
            PrintWriter printWriter = new PrintWriter(new File("./demo.txt"), StandardCharsets.UTF_8);
            printWriter.println(112312);
            printWriter.write("!23123131");
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        StanderStream standerStream = new StanderStream();
        standerStream.test2();
    }

}
