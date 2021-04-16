package io.v2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// 客户端 可重复发送消息
public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("please input:");
            String msg = scanner.nextLine();
            printStream.println(msg);
            printStream.flush();
        }
    }
}
