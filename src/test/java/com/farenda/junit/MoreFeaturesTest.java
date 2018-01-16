package com.farenda.junit;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class MoreFeaturesTest {

    @Ignore("Fix that tomorrow")
    @Test
    public void shouldBeFixedSoon() {
        assertEquals(4, Math.abs(-5));
    }

    @Test(timeout = 500)
    public void shouldDoWorkInSpecifiedTime() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        assertEquals(2, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowException() {
        Collections.swap(emptyList(), 0, 1);
    }
}
