package se.io;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class StanderStreamTest {
    StanderStream stream;

    @Before
    public void setUp() throws Exception {
        stream = new StanderStream();
    }

    @Test
    public void test1() throws IOException {
        stream.test1();
    }

    @Test
    public void test2() {
        stream.test2();
    }


}