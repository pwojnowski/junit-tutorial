package com.farenda.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class MaximumNumberFinderTest {

    @Parameter
    public int a;

    @Parameter(1)
    public int b;

    @Parameter(2)
    public int result;

    @Parameters
    public static Collection<Object[]> prepareTestData() {
        return Arrays.asList(new Integer[][] {
                {1, 2, 2},
                {23, 12, 23},
                {-7, -9, -7}
        });
    }

    @Test
    public void shouldFindMaxValue() {
        assertThat(Math.max(a, b), equalTo(result));
    }
}
