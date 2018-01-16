package com.farenda.junit;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class TheoriesWithTestedOnSupplierTest {

    @Theory
    public void shouldFindMinMaxNumbers(
            // Parameters will take only specified values:
            @TestedOn(ints = {1, 2}) int x,
            @TestedOn(ints = {3, 4}) int y) {
        // Will go through all combinations of input data.
        System.out.printf("x: %d, y: %d%n", x, y);
        assertEquals(Math.min(x,y), x);
        assertEquals(Math.max(x,y), y);
    }
}
