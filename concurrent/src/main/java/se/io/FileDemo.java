package se.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {
    public void pathToFileAndCreate() throws IOException {
        // 在当前项目的根目录下创建cc/dd/ee/ff目录
        Path path = Paths.get("./", "cc", "dd", "ee", "ff");
        File file = path.toFile();
        file.mkdirs();
        File file1 = new File(file.getPath() + "/a.txt");
        boolean newFile = file1.createNewFile();
        System.out.println(newFile);
    }

    public static void main(String[] args) throws IOException {
        FileDemo fileDemo = new FileDemo();
        fileDemo.pathToFileAndCreate();
    }
}
