package io.nio.base;

import io.nio.base.TransferFrom;
import org.junit.Before;
import org.junit.Test;

public class TransferFromTest {
    TransferFrom transferFrom;

    @Before
    public void setUp() throws Exception {
        transferFrom = new TransferFrom();
    }

    @Test
    public void test1() {
        transferFrom.test();
    }
}