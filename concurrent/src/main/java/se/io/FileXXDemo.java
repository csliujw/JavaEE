package se.io;

import java.io.*;
import java.net.URL;

/**
 * 文件输入输出流
 */
public class FileXXDemo {
    // 硬编码写法
    public void hardCode() {
        try (FileInputStream in = new FileInputStream("D:\\a.txt");) {
            System.out.println(new String(in.readAllBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getResourceAsStream() {
        try (InputStream in = this.getClass().getResourceAsStream("./_01_ItrToStream.txt")) {
            System.out.println(new String(in.readAllBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fileInput() {
        // 绝对路径 或相对路径。相对路径是以用户工作目录开始的
        // 获取项目文件的绝对路径
        // /data1.txt 以classes为根目录进行查找。
        // data1.txt 从当前文件的目录进行查找
        URL resource = FileXXDemo.class.getResource("/_01_ItrToStream.txt");
        try (FileInputStream inputStream = new FileInputStream(resource.getPath());) {
            byte[] bytes = inputStream.readAllBytes();
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileXXDemo fileXXDemo = new FileXXDemo();
        fileXXDemo.getResourceAsStream();
    }

}
