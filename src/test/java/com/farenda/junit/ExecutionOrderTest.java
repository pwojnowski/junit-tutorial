package com.farenda.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecutionOrderTest {

    @Test
    public void minNumber() {
        System.out.println("Executing first test.");
        assertEquals(42, Math.max(24, 42));
    }

    @Test
    public void maxNumber() {
        System.out.println("Executing second test.");
        assertEquals(42, Math.max(24, 42));
    }
}
