package com.farenda.junit;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore("This is still work in progress")
public class WorkInProgressTest {

    @Test
    public void mathTest() {
        assertEquals(4, Math.abs(-5));
    }
}
