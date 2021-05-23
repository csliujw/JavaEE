package se.io;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileXXDemoTest {
    FileXXDemo fileXXDemo;

    @Before
    public void setUp() {
        fileXXDemo = new FileXXDemo();
    }

    @Test
    public void fileInput() {
        fileXXDemo.fileInput();
    }

    @Test
    public void hardCode() {
        fileXXDemo.hardCode();
    }

    @Test
    public void getResourceAsStream() {
        fileXXDemo.getResourceAsStream();
    }
}