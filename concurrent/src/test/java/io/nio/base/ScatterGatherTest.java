package io.nio.base;

import io.nio.base.ScatterGather;
import org.junit.Before;
import org.junit.Test;

public class ScatterGatherTest {
    ScatterGather s;

    @Before
    public void setUp() throws Exception {
        s = new ScatterGather();
    }

    @Test
    public void demo() {
        s.demo();
    }
}