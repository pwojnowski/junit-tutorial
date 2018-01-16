package com.farenda.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RuleTheWorldTest {

    @Rule
    public TestName testName = new TestName();

    @Test
    public void shouldMultiplyNumbers() {
        System.out.println("Executing: " + testName.getMethodName());
        assertThat(7 * 7, is(49));
    }

    @Test
    public void shouldAddNumbers() {
        System.out.println("Executing: " + testName.getMethodName());
        assertThat(7 + 7, is(14));
    }
}
