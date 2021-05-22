package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Channel {
    // 使用NIO进行文件的复制
    public void copy() {
        try {
            // File 从classes下开始找文件
            File file = new File("demo.png");
            System.out.println(file.getAbsoluteFile());
            FileChannel inputChannel = new FileInputStream(file.getAbsoluteFile()).getChannel();
            FileChannel outputChannel = new FileOutputStream("./copy.png").getChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
