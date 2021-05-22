package io.nio;


import org.junit.Before;
import org.junit.Test;

public class BufferDemoTest {
    BufferDemo buffer;

    @Before
    public void init() {
        buffer = new BufferDemo();
    }

    @Test
    public void allocate() {
        buffer.allocate();
    }

    @Test
    public void api() {
        buffer.api();
    }

    @Test
    public void apiFlip() {
        buffer.apiFlip();
    }

    @Test
    public void read() {
        buffer.read();
    }
}