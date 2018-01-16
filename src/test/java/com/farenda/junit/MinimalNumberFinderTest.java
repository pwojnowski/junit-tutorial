package com.farenda.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class MinimalNumberFinderTest {

    private int a;
    private int b;
    private int result;

    @Parameters(name = "minimum of {0} and {1} is {2}")
    public static Collection<Object[]> prepareTestData() {
        return Arrays.asList(new Integer[][] {
                {1, 2, 1},
                {23, 12, 12},
                {-7, -9, -9}
        });
    }

    public MinimalNumberFinderTest(int a, int b, int result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    @Test
    public void shouldFindMinValue() {
        assertThat(Math.min(a, b), equalTo(result));
    }
}
