package io.nio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChannelTest {
    Channel c;

    @Test
    public void copy() {
        c.copy();
    }

    @Before
    public void setUp() throws Exception {
        c = new Channel();
    }
}