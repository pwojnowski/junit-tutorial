package com.farenda.junit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SubstractionTest {

    @Test
    public void shouldSubstractNumbers() {
        assertThat(42-2, is(40));
    }
}
