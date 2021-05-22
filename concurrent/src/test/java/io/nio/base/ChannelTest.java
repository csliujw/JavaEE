package io.nio.base;

import io.nio.base.Channel;
import org.junit.Before;
import org.junit.Test;

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