package com.farenda.junit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AdditionTest {

    @Test
    public void shouldAddNumbers() {
        assertThat(2+2, is(4));
    }
}
